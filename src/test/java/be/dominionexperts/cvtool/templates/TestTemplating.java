package be.dominionexperts.cvtool.templates;

import be.dominionexperts.cvtool.dto.Basics;
import be.dominionexperts.cvtool.dto.Resume;
import be.dominionexperts.cvtool.util.XDocUtils;
import fr.opensagres.xdocreport.core.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TestTemplating {

    @Test
    public void testDocumentGenerationPdf() throws IOException, URISyntaxException {
        Resume resume = Resume.newBuilder().withBasics(Basics.newBuilder().withName("Thomas").build()).build();
        URL templateFile = this.getClass().getResource("/Hello.docx");
        byte[] template = IOUtils.toByteArray(templateFile.openStream());
        String outputPath = Paths.get(templateFile.toURI()).getParent().toString();
        XDocUtils.generateDocument(template, resume, true).ifPresent(bytes -> XDocUtils.save(outputPath, "out.pdf", bytes));
    }


    @Test
    public void testDocumentGenerationDocx() throws IOException, URISyntaxException {
        Resume resume = Resume.newBuilder().withBasics(Basics.newBuilder().withName("Thomas").build()).build();
        URL templateFile = this.getClass().getResource("/Hello.docx");
        byte[] template = IOUtils.toByteArray(templateFile.openStream());
        String outputPath = Paths.get(templateFile.toURI()).getParent().toString();
        XDocUtils.generateDocument(template, resume, false).ifPresent(bytes -> XDocUtils.save(outputPath, "out.docx", bytes));
    }

}
