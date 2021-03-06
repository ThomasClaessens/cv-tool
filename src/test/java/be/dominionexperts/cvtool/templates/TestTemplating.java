package be.dominionexperts.cvtool.templates;

import be.dominionexperts.cvtool.dto.*;
import be.dominionexperts.cvtool.util.XDocUtils;
import fr.opensagres.xdocreport.core.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class TestTemplating {

    @Test
    public void testDocumentGenerationPdf() throws IOException, URISyntaxException {
        URL templateFile = new ClassPathResource("cv_template.docx").getURL();
        byte[] template = IOUtils.toByteArray(templateFile.openStream());
        String outputPath = Paths.get(templateFile.toURI()).getParent().toString();
        XDocUtils.generateDocument(template, getResumeFixture(), true).ifPresent(bytes -> save(outputPath, "out.pdf", bytes));
    }

    @Test
    public void testDocumentGenerationDocx() throws IOException, URISyntaxException {
        URL templateFile = new ClassPathResource("cv_template.docx").getURL();
        byte[] template = IOUtils.toByteArray(templateFile.openStream());
        String outputPath = Paths.get(templateFile.toURI()).getParent().toString();
        XDocUtils.generateDocument(template, getResumeFixture(), false).ifPresent(bytes -> save(outputPath, "out.docx", bytes));
    }

    private static void save(String path, String filename, byte[] bytes){
        File file = new File(path);
        file.mkdirs();
        File fullPathToFile = new File(file, filename);
        try {
            FileOutputStream outputStream = new FileOutputStream(fullPathToFile);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private Resume getResumeFixture() {
        Education education = Education.newBuilder()
                .withArea("Area")
                .withStartDate("2010")
                .withEndDate("2019")
                .withInstitution("KDG")
                .withStudyType("Bachelor")
                .build();
        Education education2 = Education.newBuilder()
                .withArea("Area")
                .withStartDate("2019")
                .withEndDate("2020")
                .withInstitution("KUL")
                .withStudyType("Master")
                .build();

        Language language = Language.newBuilder().withLanguage("Swahili").withSkillLevel("nihil").build();
        Language language2 = Language.newBuilder().withLanguage("Nederlands").withSkillLevel("moedertaal").build();

        Keyword w10Keyword = Keyword.newBuilder().withLevel((short)1).withName("Windows 10").build();
        Keyword w7Keyword = Keyword.newBuilder().withLevel((short)4).withName("Windows 7").build();
        Keyword linuxKeyword = Keyword.newBuilder().withLevel((short)3).withName("Linux").build();

        Keyword mysqlKeyword = Keyword.newBuilder().withLevel((short)1).withName("MYSQL").build();
        Keyword postgreSqlKeyword = Keyword.newBuilder().withLevel((short)2).withName("PostgreSql").build();
        Keyword oracleDBKeyword = Keyword.newBuilder().withLevel((short)5).withName("Orcale DB").build();

        Skill skill = Skill.newBuilder().withName("Database").withKeywords(List.of(mysqlKeyword, postgreSqlKeyword, oracleDBKeyword)).build();
        Skill skill2 = Skill.newBuilder().withName("OS").withKeywords(List.of(w10Keyword, w7Keyword, linuxKeyword)).build();

        Project project = Project.newBuilder()
                .withName("Project 1")
                .withDescription("Some Description")
                .withEndDate("Sep 2019")
                .withStartDate("Sep 2016")
                .withUrl("someUrl")
                .withKeywords(List.of("IntelliJ"))
                .withSector("Informatics")
                .withJobTitle("Developer")
                .build();

        return Resume.newBuilder()
                .withBasics(Basics.newBuilder().withName("Thomas").build())
                .withEducation(List.of(education,education2))
                .withLanguages(List.of(language, language2))
                .withSkills(List.of(skill, skill2))
                .withProjects(List.of(project))
                .build();
    }
}
