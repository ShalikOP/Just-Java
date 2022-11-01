package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity<numberOfCoffes> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    int numberOfCoffes = 0;

    public void increment(View view) {
        if(numberOfCoffes == 100){
            Toast.makeText(this, "You cannot order more than 100 coffes", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffes = numberOfCoffes + 1;
        display(numberOfCoffes);
    }

    public void decrement(View view) {
        if(numberOfCoffes == 1){
            Toast.makeText(this, "You cannot order less than 1 coffes", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCoffes = numberOfCoffes - 1;
        display(numberOfCoffes);
    }

    public void submitOrder(View view) {

        CheckBox whipped;
        whipped = findViewById(R.id.whipping);
        boolean whipVal = whipped.isChecked();

        CheckBox chocolate;
        chocolate = findViewById(R.id.chocolateide);
        boolean chocVal = chocolate.isChecked();

        EditText name;
        name = findViewById(R.id.editText);
        String nameperson = name.getText().toString();


        if (whipVal && chocVal) {
            int price = calculatePrice(numberOfCoffes, 8);
            String priceMessage = "  NAME: " + nameperson;
            priceMessage += "\n  Whipped cream and Chocolate both added";
            priceMessage = priceMessage + "\n  Quantity =" + numberOfCoffes;
            priceMessage += "\n  Total =$" + price;
            priceMessage += "\n  ThankYou";
            displayMessage(priceMessage);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + nameperson );
            intent.putExtra(Intent.EXTRA_EMAIL  , "mdshalique472@gmail.com");
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            startActivity(intent);
        }
        else if (whipVal) {
            int price = calculatePrice(numberOfCoffes, 6);
            String priceMessage = "  NAME: " + nameperson;
            priceMessage += "\n  Whipped cream added";
            priceMessage = priceMessage + "\n  Quantity =" + numberOfCoffes;
            priceMessage += "\n  Total =$" + price;
            priceMessage += "\n  ThankYou";
            displayMessage(priceMessage);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + nameperson );
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            startActivity(intent);


        }
        else if (chocVal) {
            int price = calculatePrice(numberOfCoffes, 7);
            String priceMessage = "  NAME: " + nameperson;
            priceMessage = priceMessage + "\n  Chocolate Added";
            priceMessage = priceMessage + "\n  Quantity =" + numberOfCoffes;
            priceMessage += "\n  Total =$" + price;
            priceMessage += "\n  ThankYou";
            displayMessage(priceMessage);


            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + nameperson );
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            startActivity(intent);
        }
        else {
            int price = calculatePrice(numberOfCoffes, 5);
            String priceMessage = "  NAME: " + nameperson;
            priceMessage = priceMessage + "\n  Quantity =" + numberOfCoffes;
            priceMessage += "\n  Total =$" + price;
            priceMessage += "\n  ThankYou";
            displayMessage(priceMessage);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + nameperson );
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            startActivity(intent);
        }

    }

    public int calculatePrice(int nOC, int valv) {
        int price = nOC * valv;
        return (price);
    }

    private void displayMessage(String message) {
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(message);
    }

    private void display(int number) {
        TextView quantity;
        quantity = findViewById(R.id.quantity);
        quantity.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView price;
        price = findViewById(R.id.price);
        price.setText("" + number);
    }
}