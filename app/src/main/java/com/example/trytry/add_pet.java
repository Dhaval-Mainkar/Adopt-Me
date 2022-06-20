package com.example.trytry;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.trytry.databinding.ActivityAddPetBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class add_pet extends AppCompatActivity {
    ActivityAddPetBinding binding;
    ActivityResultLauncher<String> launcher;
    FirebaseStorage storage;
    FirebaseDatabase database;
    EditText ptype,pgender,pname, pbreed, pdesc;
    TextView done;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    String gender = "";
    ImageView imageview,back;
    private Button btn_upload, btn_choose;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityAddPetBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        database.getReference().child("image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String data = snapshot.getValue(String.class);
                Glide.with(add_pet.this).load(data).into(binding.uploadimage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(add_pet.this, "Error:" + error, Toast.LENGTH_SHORT).show();
            }
        });


        launcher = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                binding.uploadimage.setImageURI(result);

                StorageReference reference = storage.getReference().child("image");
                reference.putFile(result).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                database.getReference().child("image").setValue(result.toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(add_pet.this, "image Successfully Upload", Toast.LENGTH_SHORT).show();
                                    }
                                });

                            }
                        });
                    }
                });
            }
        });

        ptype=findViewById(R.id.pet_type);
        pgender=findViewById(R.id.gender);
        pname = findViewById(R.id.pet_name);
        pbreed = findViewById(R.id.breed);
        pdesc = findViewById(R.id.desc);
        done = findViewById(R.id.done_btn);
        btn_choose = findViewById(R.id.btn_choose);
        imageview = findViewById(R.id.uploadimage);
        back=findViewById(R.id.edit_back_btn);

        binding.btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launcher.launch("image/*");
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("pets");
                String type = ptype.getText().toString();
                String gender = pgender.getText().toString();
                String name = pname.getText().toString();
                String breed = pbreed.getText().toString();
                String desc = pdesc.getText().toString();

                post helperclass = new post(type,gender,name, breed, desc);
                reference.child(breed).setValue(helperclass);

                if (TextUtils.isEmpty(type)) {
                    Toast.makeText(add_pet.this, "Please enter type of animal", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(gender)) {
                    Toast.makeText(add_pet.this, "Please enter gender", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(add_pet.this, "Please enter name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(breed)) {
                    Toast.makeText(add_pet.this, "Please enter breed", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(desc)) {
                    Toast.makeText(add_pet.this, "Please enter desc", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Home.class));
            }
        });

    }
}











