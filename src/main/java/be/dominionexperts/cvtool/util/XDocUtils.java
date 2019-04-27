package be.dominionexperts.cvtool.util;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.GenerationFailedException;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

import java.io.*;
import java.util.Optional;

public class XDocUtils {

    public static Optional<byte[]> generateDocument(byte[] template, Resume resumeData, boolean convertToPdf) {
        try (InputStream in = new ByteArrayInputStream(template)) {
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
            IContext context = buildContext(report, resumeData);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Options options;
            if (convertToPdf) {
                options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
                report.convert(context, options, out);
            } else {
                report.process(context, out);
            }
            return Optional.of(out.toByteArray());
        } catch (Exception e) {
            throw new GenerationFailedException(e.getMessage(), e);
        }
    }

    private static IContext buildContext(IXDocReport report, Resume resumeData) {
        try {
            FieldsMetadata fieldsMetadata = report.createFieldsMetadata();

            IContext context = report.createContext();
            context.put("resume", resumeData);
            fieldsMetadata.load("resume", Resume.class, false);

            return context;
        } catch (XDocReportException e) {
            throw new GenerationFailedException(e.getMessage(), e);
        }
    }
}
