package Adaptador;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pi.R;

import java.util.List;

import Modelos.Nutricion;

public class NutricionAdapter extends RecyclerView.Adapter<NutricionAdapter.NutricionViewHolder> {
    private Context Ctx;
    private List<Nutricion> lstNutricion;

    public NutricionAdapter(Context mCtx, List<Nutricion> nutricion) {
        this.lstNutricion = nutricion;
        Ctx = mCtx;
    }

    @Override
    public NutricionAdapter.NutricionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.ly_nutricion, null);
        return new NutricionAdapter.NutricionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NutricionAdapter.NutricionViewHolder holder, int position) {
        Nutricion nutricion = lstNutricion.get(position);
        holder.itemName.setText(nutricion.getNombre());
        holder.itemCalories.setText(String.valueOf(nutricion.getCalorias()));
        holder.itemCarbs.setText(String.valueOf(nutricion.getCarbohidratos()));
        holder.itemProtein.setText(String.valueOf(nutricion.getProteinas()));
        holder.itemFat.setText(String.valueOf(nutricion.getGrasas()));


        Glide.with(Ctx)
                .load(nutricion.getImagen())
                .into(holder.imgUrlImage);
    }

    @Override
    public int getItemCount() {
        return lstNutricion.size();
    }

    class NutricionViewHolder extends RecyclerView.ViewHolder {
        ImageView imgUrlImage;
        public TextView itemName, itemCalories, itemCarbs, itemProtein, itemFat;
        public NutricionViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.nombreTextView);
            itemCalories = itemView.findViewById(R.id.caloriasTextView);
            itemCarbs = itemView.findViewById(R.id.carbohidratosTextView);
            itemProtein = itemView.findViewById(R.id.proteinasTextView);
            itemFat = itemView.findViewById(R.id.grasasTextView);
            imgUrlImage = itemView.findViewById(R.id.imgImage);
        }
    }
}
