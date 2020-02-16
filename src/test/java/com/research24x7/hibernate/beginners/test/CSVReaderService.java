package com.research24x7.hibernate.beginners.test;

import com.research24x7.hibernate.beginners.entity.Employee;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVReaderService {

    private static final Logger logger = Logger.getLogger(CSVReaderService.class);


    public CSVReaderService() {

        super();
    }

    public List<Employee> load(String path) {

        logger.debug(String.format("Reading file %s", path));
        List<Employee> list = new ArrayList<>();

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            logger.debug(String.format("Loading values from file %s", path));
            while ((line = br.readLine()) != null) {

                logger.debug(String.format("Getting new line from file %s", path));
                String[] val = line.split(cvsSplitBy);//  EL SEPARADOR
                logger.debug(String.format("Line %s loaded from file %s", Arrays.toString(val), path));

                Employee customer = new Employee();

                customer.setName(val[0].trim());

                customer.setLast_name(val[1].trim());

                customer.setEmail((val[2].trim()));

                customer.setMobile(String.valueOf(val[3].trim()));

                customer.setDni(String.valueOf(val[4].trim()));

                customer.setRaw (line);

                logger.debug(String.format("Adding %s to list", customer));
                list.add(customer);

            }

        } catch (Exception e) {

            logger.error(String.format("Problems loading lines from %s", path), e);
        }

        logger.debug(String.format("Return %d values", list.size()));
        return list;
    }
}
