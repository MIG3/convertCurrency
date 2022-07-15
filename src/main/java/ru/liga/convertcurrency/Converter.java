package ru.liga.convertcurrency;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Converter
{
    public String converterCurrency(List<CurrencyData> repository, String fromCur, String toCur, int count)
    {
        Double fromNominal = 1d;
        Double toNominal = 1d;
        CurrencyData cd = new CurrencyData();
        cd.setCode("RUB");
        cd.setNominal(1);
        cd.setName("Российский рубль");
        cd.setMoney(1d);
        repository.add(cd);
        for (CurrencyData data: repository)
        {
            if (data.getCode().equals(fromCur))
            {
                fromNominal = data.getMoney() / data.getNominal() * count;
            }
            if (data.getCode().equals(toCur))
            {
                toNominal = data.getMoney() / data.getNominal() * count;
            }
        }
        return toCur + ": " + toNominal / fromNominal;
    }
}
