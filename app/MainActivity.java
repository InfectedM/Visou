import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RegistroAdapter registroAdapter;
    private List<Registro> registroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        registroList = new ArrayList<>();
        registroAdapter = new RegistroAdapter(registroList);
        recyclerView.setAdapter(registroAdapter);

        FloatingActionButton fabAddRegistro = findViewById(R.id.fabAddRegistro);
        fabAddRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir a janela de criação do novo registro
                // Implemente essa lógica de acordo com suas necessidades
            }
        });
    }

    private static class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder> {

        private List<Registro> registros;

        public RegistroAdapter(List<Registro> registros) {
            this.registros = registros;
        }

        @Override
        public RegistroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_registro, parent, false);
            return new RegistroViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RegistroViewHolder holder, int position) {
            Registro registro = registros.get(position);
            holder.tvObra.setText(registro.getObra());
            holder.tvDonoObra.setText(registro.getDonoObra());
            holder.tvEntidadeExecutante.setText(registro.getEntidadeExecutante());
        }

        @Override
        public int getItemCount() {
            return registros.size();
        }

        public static class RegistroViewHolder extends RecyclerView.ViewHolder {
            TextView tvObra;
            TextView tvDonoObra;
            TextView tvEntidadeExecutante;

            public RegistroViewHolder(View itemView) {
                super(itemView);
                tvObra = itemView.findViewById(R.id.tvObra);
                tvDonoObra = itemView.findViewById(R.id.tvDonoObra);
                tvEntidadeExecutante = itemView.findViewById(R.id.tvEntidadeExecutante);
            }
        }
    }

    private static class Registro {
        private String obra;
        private String donoObra;
        private String entidadeExecutante;

        public Registro(String obra, String donoObra, String entidadeExecutante) {
            this.obra = obra;
            this.donoObra = donoObra;
            this.entidadeExecutante = entidadeExecutante;
        }

        public String getObra() {
            return obra;
        }

        public String getDonoObra() {
            return donoObra;
        }

        public String getEntidadeExecutante() {
            return entidadeExecutante;
        }
    }
}
