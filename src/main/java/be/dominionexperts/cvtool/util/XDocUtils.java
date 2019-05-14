package be.dominionexperts.cvtool.util;

import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.exception.GenerationFailedException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.pdf.BaseFont;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.springframework.core.io.ClassPathResource;

import java.awt.Color;
import java.io.*;
import java.util.Optional;

public class XDocUtils {

    public static Optional<byte[]> generateDocument(byte[] template, Resume resumeData, boolean convertToPdf) {
        try (InputStream in = new ByteArrayInputStream(template)) {
            IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
            IContext context = buildContext(report, resumeData);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Options options;

	        PdfOptions pdfOptions = PdfOptions.create();
	        pdfOptions.fontProvider(new IFontProvider() {
		        @Override
		        public Font getFont(String familyName, String encoding, float size, int style, Color color) {
			        try {
				        if (familyName.equalsIgnoreCase("SYMBOL")) {
					        BaseFont baseFont =
							        BaseFont.createFont( new ClassPathResource("fonts/symbol.ttf").getURL().toString(), encoding, BaseFont.EMBEDDED);
					        return new Font(baseFont, size, style, color);

				        }
				        if (familyName.equalsIgnoreCase("CALIBRI")) {
					        BaseFont baseFont =
							        BaseFont.createFont( new ClassPathResource("fonts/calibri.ttf").getURL().toString(), encoding, BaseFont.EMBEDDED);
					        return new Font(baseFont, size, style, color);

				        }
				        if (familyName.equalsIgnoreCase("NOTO SANS SYMBOLS")) {
					        BaseFont baseFont =
							        BaseFont.createFont( new ClassPathResource("fonts/notoSansSymbols.ttf").getURL().toString(), encoding, BaseFont.EMBEDDED);
					        return new Font(baseFont, size, style, color);

				        }
				        if (familyName.equalsIgnoreCase("TIMES NEW ROMAN")) {
					        BaseFont baseFont =
							        BaseFont.createFont( new ClassPathResource("fonts/timesNewRoman.ttf").getURL().toString(), encoding, BaseFont.EMBEDDED);
					        return new Font(baseFont, size, style, color);

				        }
				        if (familyName.equalsIgnoreCase("VERDANA")) {
					        BaseFont baseFont =
							        BaseFont.createFont( new ClassPathResource("fonts/verdana.ttf").getURL().toString(), encoding, BaseFont.EMBEDDED);
					        return new Font(baseFont, size, style, color);

				        }
				        if (familyName.equalsIgnoreCase( "COURIER NEW")) {
					        BaseFont baseFont =
							        BaseFont.createFont( new ClassPathResource("fonts/courierNew.ttf").getURL().toString(), encoding, BaseFont.EMBEDDED);
					        return new Font(baseFont, size, style, color);

				        }
			        } catch (Exception e) {
				        throw new RuntimeException(e);
			        }

			        return FontFactory.getFont(familyName, encoding, size, style, color);
		        }
	        });

            if (convertToPdf) {
                options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF);
	            options.subOptions(pdfOptions);
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
