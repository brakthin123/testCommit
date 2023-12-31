package com.example.myprojectstudy.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myprojectstudy.api.model.Province;
import com.example.myprojectstudy.databinding.ViewHolderProvinceBinding;
import com.squareup.picasso.Picasso;


public class ProvinceAdapter extends ListAdapter<Province, ProvinceAdapter.ProvinceViewHolder> {

    public ProvinceAdapter() {
        super(new DiffUtil.ItemCallback<Province>() {
            @Override
            public boolean areItemsTheSame(@NonNull Province oldItem, @NonNull Province newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Province oldItem, @NonNull Province newItem) {
                return oldItem.getId() == newItem.getId();
            }
        });
    }

    @NonNull
    @Override
    public ProvinceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderProvinceBinding binding = ViewHolderProvinceBinding.inflate(layoutInflater, parent, false);
        return new ProvinceViewHolder(binding);
    }
    //get data in bind in view
    @Override
    public void onBindViewHolder(@NonNull ProvinceViewHolder holder, int position) {

        Province item = getItem(position);
        holder.bind(item);

    }

    public static class ProvinceViewHolder extends RecyclerView.ViewHolder {

        private final ViewHolderProvinceBinding itemBinding;

        public ProvinceViewHolder(ViewHolderProvinceBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }

        public void bind(Province province) {
            Picasso.get().load(province.getImageUrl()).into(itemBinding.imageProvince);
            itemBinding.textName.setText(province.getName());

        }

    }

}