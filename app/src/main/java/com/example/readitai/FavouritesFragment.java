package com.example.readitai;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class FavouritesFragment extends Fragment {

    private DbHandler dbHandler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbHandler = new DbHandler(requireActivity().getApplicationContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.favourites_fragment, null);
        TextView links = v.findViewById(R.id.links);

        try {
            String firstLink = joinWithNewlines(dbHandler.getAllLinks());
            links.setText(firstLink);
        } catch (IndexOutOfBoundsException e) {
            links.setText("No favourites yet!");
        }

        return v;
    }

    public static String joinWithNewlines(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : stringList) {
            sb.append(str).append("\n");
        }


        sb.setLength(sb.length() - 1);

        return sb.toString();
    }

}

