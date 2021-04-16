package com.example.testapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PersonViewHolder> {

    private List<Person> personList;

    public RecyclerAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sport,parent,false);

        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.personName.setText(person.getPersonName());
        holder.personIamge.setImageResource(person.getPersonImage());
        holder.nameSport.setText(person.getNameSport());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        public TextView personName,nameSport;
        public CircleImageView personIamge;


        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.footbol_name);
            personIamge = itemView.findViewById(R.id.footbol_image);
            nameSport = itemView.findViewById(R.id.name_sport);
        }
    }
}
