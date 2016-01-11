package application;

import moneycalculator.control.ExchangeCommand;
import moneycalculator.persistence.MockExchangeRateReader;
import moneycalculator.ui.MockCurrencyDialog;
import moneycalculator.ui.MockMoneyDialog;
import moneycalculator.ui.MockMoneyDisplay;

public class Application {

    public static void main(String[] args) {
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                new MockMoneyDialog(),
                new MockCurrencyDialog(),
                new MockExchangeRateReader(),
                new MockMoneyDisplay()
        );
        exchangeCommand.execute();
    }
}
