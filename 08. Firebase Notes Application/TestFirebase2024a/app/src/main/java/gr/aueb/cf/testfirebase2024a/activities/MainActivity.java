package gr.aueb.cf.testfirebase2024a.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.util.ArrayList;

import gr.aueb.cf.testfirebase2024a.R;
import gr.aueb.cf.testfirebase2024a.adapters.NoteAdapter;
import gr.aueb.cf.testfirebase2024a.helpers.DBHelper;
import gr.aueb.cf.testfirebase2024a.helpers.DateStampHelper;
import gr.aueb.cf.testfirebase2024a.models.Note;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private FirebaseAuth auth;
    private FloatingActionButton addBtn;
    public RecyclerView recyclerView;

    private String titleColor;
    private String descriptionColor;
    private String backgroundColor;
    private ArrayList<Note> noteArrayList;


    private NoteAdapter noteAdapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        addBtn = findViewById(R.id.addBtn);
        recyclerView = findViewById(R.id.recyclerView);
        noteArrayList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        // initial colors
        titleColor = "FF000000";
        descriptionColor = "FF000000";
        backgroundColor = "FFFFFFFF";

        // present all notes!
        DBHelper.getNotesReference().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // clear my list!
                noteArrayList.clear();

                if (snapshot.exists()) {
                    for (DataSnapshot data : snapshot.getChildren()) {
                        Note note = data.getValue(Note.class);
                        if (note != null) {
                            noteArrayList.add(note);
                        }
                    }
                    // important to do it here!
                    noteAdapter = new NoteAdapter(getApplicationContext(), noteArrayList);
                    recyclerView.setAdapter(noteAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleColor = "FF000000";
                descriptionColor = "FF000000";
                backgroundColor = "FFFFFFFF";
                showAlertDialog();
            }
        });

        materialToolbar = findViewById(R.id.toolbar);
        materialToolbar.inflateMenu(R.menu.menu_item);

        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.logout) {
                    auth.signOut();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
                return true;
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);

        EditText titleEt = dialogView.findViewById(R.id.titleEt);
        EditText descriptionET = dialogView.findViewById(R.id.descriptionET);
        MaterialButton titleColorBtn = dialogView.findViewById(R.id.titleColorBtn);
        MaterialButton descriptionColorBtn = dialogView.findViewById(R.id.descriptionColorBtn);
        MaterialButton backgroundColorBtn = dialogView.findViewById(R.id.backgroundColorBtn);
        MaterialTextView sampleTitleTV = dialogView.findViewById(R.id.sampleTitleTV);
        MaterialTextView sampleDescriptionTV = dialogView.findViewById(R.id.sampleDescriptionTV);
        ConstraintLayout sampleConstraintLayout = dialogView.findViewById(R.id.sampleConstraintLayout);

        backgroundColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPickerDialog.Builder(MainActivity.this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        backgroundColorBtn.setBackgroundColor(envelope.getColor());
                                        backgroundColor = envelope.getHexCode();
                                        sampleConstraintLayout.setBackgroundColor(envelope.getColor());
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
            }
        });

        titleColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPickerDialog.Builder(MainActivity.this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        sampleTitleTV.setTextColor(envelope.getColor());
                                        titleColorBtn.setBackgroundColor(envelope.getColor());
                                        titleColor = envelope.getHexCode();
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
            }
        });

        descriptionColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPickerDialog.Builder(MainActivity.this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        sampleDescriptionTV.setTextColor(envelope.getColor());
                                        descriptionColorBtn.setBackgroundColor(envelope.getColor());
                                        descriptionColor = envelope.getHexCode();
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
            }
        });

        builder.setTitle("Crate a new note")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = titleEt.getText().toString();
                        String description = descriptionET.getText().toString();

                        if (title.isEmpty()) {
                            titleEt.setError("Please enter a title");
                            titleEt.requestFocus();
                            return;
                        }
                        if (description.isEmpty()) {
                            descriptionET.setError("Please enter a description");
                            descriptionET.requestFocus();
                            return;
                        }

                        String noteId = DBHelper.getNotesReference().push().getKey();
                        Note note = new Note(noteId, title, description, backgroundColor, titleColor, descriptionColor, DateStampHelper.getDateStamp());

                        //....
                        // auth.getCurrentUser().getUid();
                        // databaseReference.getReference(getCurrentUserId()).child("notes")
                        DBHelper.getNotesReference().child(noteId).setValue(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity.this, "Note created!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        // dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform any action you want when the Cancel button is clicked
                        dialog.dismiss(); // Close the dialog
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showEditAlertDialog(String noteId, String noteTitle, String noteDescription, String titleColor, String descriptionColor, String backgroundColor) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_dialog, null);
        builder.setView(dialogView);

        EditText titleEt = dialogView.findViewById(R.id.titleEt);
        EditText descriptionET = dialogView.findViewById(R.id.descriptionET);
        MaterialButton titleColorBtn = dialogView.findViewById(R.id.titleColorBtn);
        MaterialButton descriptionColorBtn = dialogView.findViewById(R.id.descriptionColorBtn);
        MaterialButton backgroundColorBtn = dialogView.findViewById(R.id.backgroundColorBtn);
        MaterialTextView sampleTitleTV = dialogView.findViewById(R.id.sampleTitleTV);
        MaterialTextView sampleDescriptionTV = dialogView.findViewById(R.id.sampleDescriptionTV);
        ConstraintLayout sampleConstraintLayout = dialogView.findViewById(R.id.sampleConstraintLayout);

        titleEt.setText(noteTitle);
        descriptionET.setText(noteDescription);
        sampleTitleTV.setTextColor(Color.parseColor("#" + titleColor));
        sampleDescriptionTV.setTextColor(Color.parseColor("#" + descriptionColor));
        sampleConstraintLayout.setBackgroundColor(Color.parseColor("#" + backgroundColor));
        titleColorBtn.setBackgroundColor(Color.parseColor("#" + titleColor));
        descriptionColorBtn.setBackgroundColor(Color.parseColor("#" + descriptionColor));
        backgroundColorBtn.setBackgroundColor(Color.parseColor("#" + backgroundColor));
        MainActivity.this.backgroundColor = backgroundColor;
        MainActivity.this.titleColor = titleColor;
        MainActivity.this.descriptionColor = descriptionColor;

        backgroundColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPickerDialog.Builder(MainActivity.this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        backgroundColorBtn.setBackgroundColor(envelope.getColor());
                                        MainActivity.this.backgroundColor = envelope.getHexCode();
                                        sampleConstraintLayout.setBackgroundColor(envelope.getColor());
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
            }
        });

        titleColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPickerDialog.Builder(MainActivity.this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        sampleTitleTV.setTextColor(envelope.getColor());
                                        titleColorBtn.setBackgroundColor(envelope.getColor());
                                        MainActivity.this.titleColor = envelope.getHexCode();
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
            }
        });

        descriptionColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ColorPickerDialog.Builder(MainActivity.this)
                        .setTitle("ColorPicker Dialog")
                        .setPreferenceName("MyColorPickerDialog")
                        .setPositiveButton(getString(R.string.confirm),
                                new ColorEnvelopeListener() {
                                    @Override
                                    public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                        sampleDescriptionTV.setTextColor(envelope.getColor());
                                        descriptionColorBtn.setBackgroundColor(envelope.getColor());
                                        MainActivity.this.descriptionColor = envelope.getHexCode();
                                    }
                                })
                        .setNegativeButton(getString(R.string.cancel),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                    }
                                })
                        .attachAlphaSlideBar(true) // the default value is true.
                        .attachBrightnessSlideBar(true)  // the default value is true.
                        .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                        .show();
            }
        });

        builder.setTitle("Edit note")
                .setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = titleEt.getText().toString();
                        String description = descriptionET.getText().toString();

                        if (title.isEmpty()) {
                            titleEt.setError("Please enter a title");
                            titleEt.requestFocus();
                            return;
                        }
                        if (description.isEmpty()) {
                            descriptionET.setError("Please enter a description");
                            descriptionET.requestFocus();
                            return;
                        }
                        Note note = new Note(noteId, title, description, MainActivity.this.backgroundColor, MainActivity.this.titleColor, MainActivity.this.descriptionColor, DateStampHelper.getDateStamp());

                        DBHelper.getNotesReference().child(noteId).setValue(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity.this, "Note edited successfully!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform any action you want when the Cancel button is clicked
                        itemTouchHelper.attachToRecyclerView(null);
                        itemTouchHelper.attachToRecyclerView(recyclerView);
                        dialog.dismiss(); // Close the dialog
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            if (direction == ItemTouchHelper.LEFT) {
                Toast.makeText(MainActivity.this, "LEFT", Toast.LENGTH_SHORT).show();
                int position = viewHolder.getAdapterPosition();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Are you sure that you want to edit the note?");
                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Note note = noteArrayList.get(position);
                        String noteTitle = note.getTitle();
                        String noteDescription = note.getDescription();
                        String titleColor = note.getTitleColor();
                        String descriptionColor = note.getDescriptionColor();
                        String backgroundColor = note.getBackgroundColor();
                        String noteId = note.getId();

                        showEditAlertDialog(noteId, noteTitle, noteDescription, titleColor, descriptionColor, backgroundColor);
                        dialog.dismiss();

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemTouchHelper.attachToRecyclerView(null);
                        itemTouchHelper.attachToRecyclerView(recyclerView);
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            } else if (direction == ItemTouchHelper.RIGHT) {
                int position = viewHolder.getAdapterPosition();
                //Toast.makeText(MainActivity.this, "RIGHT", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Are you sure that you want to DELETE the note?");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Note deletedNote = noteArrayList.get(position);

                        DBHelper.getNotesReference().child(noteArrayList.get(position).getId()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @SuppressLint("NotifyDataSetChanged")
                            @Override
                            public void onSuccess(Void unused) {
                                noteAdapter.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this, "Note deleted", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        Snackbar snackbar =  Snackbar.make(recyclerView, "Noted deleted", Snackbar.LENGTH_LONG);
                        snackbar.setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                DBHelper.getNotesReference().child(deletedNote.getId()).setValue(deletedNote).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(MainActivity.this, "Note restored!", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });
                        snackbar.show();
                        dialog.dismiss();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        itemTouchHelper.attachToRecyclerView(null);
                        itemTouchHelper.attachToRecyclerView(recyclerView);
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            View itemView = viewHolder.itemView;
            ColorDrawable myBackgroundColor = new ColorDrawable();

            if (dX > 0) { // Swiping to the right
                myBackgroundColor.setColor(ContextCompat.getColor(getApplicationContext(), R.color.deleteColor));
                myBackgroundColor.setBounds(itemView.getLeft() + (int) dX, itemView.getTop(), itemView.getLeft(), itemView.getBottom() );
                myBackgroundColor.draw(c);
                Drawable icon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_delete);

                int iconHorizontalMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, recyclerView.getContext().getResources().getDisplayMetrics());
                if (icon != null) {
                    int intrinsicHeight = icon.getIntrinsicHeight();
                    int halfIcon = intrinsicHeight / 2;
                    int top = viewHolder.itemView.getTop() + ((viewHolder.itemView.getBottom() - viewHolder.itemView.getTop()) / 2 - halfIcon);
                    icon.setBounds(viewHolder.itemView.getLeft() + iconHorizontalMargin, top, viewHolder.itemView.getLeft() + iconHorizontalMargin + icon.getIntrinsicWidth(), top + icon.getIntrinsicHeight());
                    icon.draw(c);
                }
            } else if (dX < 0) { // Swiping to the left
                myBackgroundColor.setColor(ContextCompat.getColor(getApplicationContext(), R.color.editColor));
                myBackgroundColor.setBounds(itemView.getRight() + (int) dX, itemView.getTop(), itemView.getRight(), itemView.getBottom() );
                myBackgroundColor.draw(c);
                Drawable icon = ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_edit);

                int iconHorizontalMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, recyclerView.getContext().getResources().getDisplayMetrics());
                if (icon != null) {
                    int intrinsicHeight = icon.getIntrinsicHeight();
                    int halfIcon = intrinsicHeight / 2;
                    int top = viewHolder.itemView.getTop() + ((viewHolder.itemView.getBottom() - viewHolder.itemView.getTop()) / 2 - halfIcon);
                    int imgLeft = viewHolder.itemView.getRight() - iconHorizontalMargin - halfIcon * 2;
                    icon.setBounds(imgLeft, top, viewHolder.itemView.getRight() - iconHorizontalMargin, top + icon.getIntrinsicHeight());
                    icon.draw(c);
                }
            }
        }
    };

}