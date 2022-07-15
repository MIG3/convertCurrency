package ru.liga.convertcurrency;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCurrency
{
    public void printCodeAndCurrency(List<CurrencyData> repository)
    {
        for (CurrencyData line : repository)
        {
            System.out.println(line.getCode() + " " + line.getName());
        }
    }
}
