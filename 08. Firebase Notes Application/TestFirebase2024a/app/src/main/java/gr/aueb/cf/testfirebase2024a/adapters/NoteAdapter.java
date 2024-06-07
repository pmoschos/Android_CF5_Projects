package gr.aueb.cf.testfirebase2024a.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

import gr.aueb.cf.testfirebase2024a.R;
import gr.aueb.cf.testfirebase2024a.models.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private Context context;
    private ArrayList<Note> noteArrayList;

    public NoteAdapter(Context context, ArrayList<Note> noteArrayList) {
        this.context = context;
        this.noteArrayList = noteArrayList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = noteArrayList.get(position);
        holder.titleTV.setText(note.getTitle());
        holder.titleTV.setTextColor(Color.parseColor("#" + note.getTitleColor()));
        holder.descriptionTV.setText(note.getDescription());
        holder.descriptionTV.setTextColor(Color.parseColor("#" + note.getDescriptionColor()));
        holder.cardViewConstraintLayout.setBackgroundColor(Color.parseColor("#" + note.getBackgroundColor()));
    }

    @Override
    public int getItemCount() {
        return noteArrayList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private MaterialTextView titleTV;
        private MaterialTextView descriptionTV;
        private ConstraintLayout cardViewConstraintLayout;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            descriptionTV = itemView.findViewById(R.id.descriptionTV);
            cardViewConstraintLayout = itemView.findViewById(R.id.cardViewConstraintLayout);
        }
    }
}
