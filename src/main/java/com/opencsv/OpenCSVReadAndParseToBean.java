package com.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class OpenCSVReadAndParseToBean {

    private static final String SAMPLE_CSV_FILE_PATH = "/home/admin142/IdeaProjects/OpenCSVExample/users-with-header.csv";

    public static void main(String[] args) {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));

            CsvToBean<CSVUser> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CSVUser> csvUsers = cavToBean.parse();
            for (CSVUser csvUser : csvUsers) {
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("Phone : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("*****************************");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}