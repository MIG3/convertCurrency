package ru.liga.convertcurrency;

import java.time.LocalDate;

public class CurrencyData
{
    private String Code;
    private int Nominal;
    private String Name;
    private double Money;

/*    public CurrencyData(String code, int nominal, String name, double money)
    {
        Code = code;
        Nominal = nominal;
        Name = name;
        Money = money;
    }*/

    public void setNominal(int nominal)
    {
        Nominal = nominal;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public void setMoney(double money)
    {
        Money = money;
    }

    public void setCode(String code)
    {
        Code = code;
    }

    public int getNominal()
    {
        return Nominal;
    }

    public String getName()
    {
        return Name;
    }

    public double getMoney()
    {
        return Money;
    }

    public String getCode()
    {
        return Code;
    }


}
