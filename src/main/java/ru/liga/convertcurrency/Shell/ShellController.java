package ru.liga.convertcurrency.Shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.liga.convertcurrency.Converter;
import ru.liga.convertcurrency.CurrencyData;
import ru.liga.convertcurrency.ListCurrency;
import ru.liga.convertcurrency.ParsingFile;

import java.io.IOException;
import java.util.List;

@ShellComponent
public class ShellController
{
    private final ListCurrency listCurrency;
    private final Converter converter;
    private final ParsingFile repo;

    public ShellController(ListCurrency listCurrency, Converter converter, ParsingFile repo)
    {
        this.listCurrency = listCurrency;
        this.converter = converter;
        this.repo = repo;
    }

    @ShellMethod("Список кодов валют с расшифровкой.")
    public void codes() throws IOException
    {
        List<CurrencyData> currencyDataList = repo.parsingFile("src/main/resources/currencies.tsv");
        listCurrency.printCodeAndCurrency(currencyDataList);
    }

    @ShellMethod("Конвертация одной валюты в другую.")
    public void convert(@ShellOption int nominal, @ShellOption String from, @ShellOption String to) throws IOException
    {
        List<CurrencyData> currencyDataList = repo.parsingFile("src/main/resources/currencies.tsv");
        System.out.println(converter.converterCurrency(currencyDataList, from, to, nominal));
    }
}
