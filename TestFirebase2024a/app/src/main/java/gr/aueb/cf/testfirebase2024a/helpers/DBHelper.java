package gr.aueb.cf.testfirebase2024a.helpers;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class DBHelper {
    public static FirebaseDatabase databaseReference = FirebaseDatabase.getInstance();
    public static FirebaseAuth auth = FirebaseAuth.getInstance();

    public static DatabaseReference getNotesReference() {
        return databaseReference.getReference(getCurrentUserId()).child("notes");
    }

    public static DatabaseReference getSimpleNotesReference() {
        return databaseReference.getReference("notes");
    }

    public static String getCurrentUserId() {
        return Objects.requireNonNull(auth.getCurrentUser()).getUid();
    }
}
