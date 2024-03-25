package com.myprojects.expense_tracking;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    private Spinner itemSpinner;
    private EditText amountEditText, noteEditText;
    private Button cancelButton, saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_layout);

        // Initialize views
        itemSpinner = findViewById(R.id.itemspinner);
        amountEditText = findViewById(R.id.amount);
        noteEditText = findViewById(R.id.note);
        cancelButton = findViewById(R.id.cancel);
        saveButton = findViewById(R.id.save);

        // Set up onClickListener for the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBudgetItem();
            }
        });

        // Set up onClickListener for the cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cancel action (if needed)
                finish(); // Close the activity
            }
        });

        // Set up item selected listener for the spinner
        itemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle item selection (if needed)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle case where nothing is selected (if needed)
            }
        });
    }

    // Method to save the budget item
    private void saveBudgetItem() {
        // Retrieve input from views
        String selectedItem = itemSpinner.getSelectedItem().toString();
        String amount = amountEditText.getText().toString();
        String note = noteEditText.getText().toString();

        // Perform validation (e.g., check if amount is not empty)
        if (amount.isEmpty()) {
            // Show error message if amount is empty
            Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the saved data (e.g., save to database)
        // TODO: Add your code here to save the budget item

        // Show a success message
        Toast.makeText(this, "Budget item saved successfully", Toast.LENGTH_SHORT).show();

        // Finish the activity
        finish();
    }
}
