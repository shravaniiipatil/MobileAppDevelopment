package com.example.allcontrolsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;
    CheckBox checkAction, checkComedy;
    RadioGroup radioGroup;
    Spinner spinner;
    RatingBar ratingBar;
    ProgressBar progressBar;
    Button btnRate, btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        checkAction = findViewById(R.id.checkAction);
        checkComedy = findViewById(R.id.checkComedy);
        radioGroup = findViewById(R.id.radioGroup);
        spinner = findViewById(R.id.spinnerMovies);
        ratingBar = findViewById(R.id.ratingBar);
        progressBar = findViewById(R.id.progressBar);
        btnRate = findViewById(R.id.btnRate);
        btnBook = findViewById(R.id.btnBook);

        // Spinner Movies
        String[] movies = {"Jawan", "Avengers", "Pushpa", "RRR"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, movies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Poster Click
        imageButton.setOnClickListener(v ->
                Toast.makeText(this, "Movie Poster Clicked 🎬", Toast.LENGTH_SHORT).show());

        // Rating Submit
        btnRate.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            Toast.makeText(this, "You Rated: " + rating + " ⭐", Toast.LENGTH_LONG).show();
        });

        // Book Ticket
        btnBook.setOnClickListener(v -> {
            progressBar.setVisibility(View.VISIBLE);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirm Booking")
                    .setMessage("Do you want to book this movie?")
                    .setPositiveButton("Yes", (dialog, id) ->
                            Toast.makeText(this, "Ticket Booked 🎟️", Toast.LENGTH_SHORT).show())
                    .setNegativeButton("No", (dialog, id) ->
                            dialog.cancel());
            builder.show();
        });
    }
}