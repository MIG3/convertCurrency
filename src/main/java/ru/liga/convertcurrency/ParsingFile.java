package ru.liga.convertcurrency;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ParsingFile
{
    public List<CurrencyData> parsingFile(String filePath) throws IOException
    {
        List<CurrencyData> currencyDataList = new ArrayList<CurrencyData>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), Charset.defaultCharset()))
        {

            String line = null;
            line = reader.readLine();
            while ((line = reader.readLine())!=null)
            {
                CurrencyData data = new CurrencyData();
                String[] record = line.split("\t");
                data.setCode(record[0]);
                String nom = record[1].trim().replace(" ", "");
                data.setNominal(Integer.parseInt(nom));
                data.setName(record[2]);
                data.setMoney(Double.parseDouble(record[3].replaceAll(",", ".")));

                currencyDataList.add(data);
            }
        } catch (NullPointerException ex)
        {
            throw new NullPointerException("Произошла ошибка чтения файла!");
        }
        return currencyDataList;
    }
}
