package android.example.mobsysfinals;

import android.content.Intent;
import android.example.mobsysfinals.databinding.ActivityLoginBinding;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {


    ActivityLoginBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Initialize view flipping
        binding.viewFlipper.setFlipInterval(2000);
        binding.viewFlipper.startFlipping();

        // Sign-in button click listener
        binding.signIn.setOnClickListener(v -> {
            String user = binding.txtUser.getText().toString();
            String pass = binding.txtPass.getText().toString();

            if (isValidLogin(user, pass)) {
                Intent intent;
                if (user.equals("admin")) {
                    intent = new Intent(Login.this, MainActivity.class);
                }
                 else {
                    Toast.makeText(Login.this, "Invalid role", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private boolean isValidLogin(String user, String pass) {
        // Replace with your actual login validation logic
        return (user.equals("admin") && pass.equals("admin"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.viewFlipper.startFlipping();

    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.viewFlipper.stopFlipping();
    }
}