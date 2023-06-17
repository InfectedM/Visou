import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.visou.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var registroAdapter: RegistroAdapter
    private val registros: MutableList<Registro> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar a RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        registroAdapter = RegistroAdapter(registros)
        recyclerView.adapter = registroAdapter

        // Configurar o botão de adicionar registro
        findViewById<Button>(R.id.btnAddRegistro).setOnClickListener { adicionarRegistro() }

        // Adicionar um registro de exemplo para fins de demonstração
        adicionarRegistro()
    }

    private fun adicionarRegistro() {
        // Criar um novo registro vazio
        val novoRegistro = Registro("", "", "")
        registros.add(novoRegistro)
        registroAdapter.notifyDataSetChanged()
    }
}

class RegistroAdapter(private val registros: List<Registro>) :
    RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder>() {

    class RegistroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val etObra: EditText = view.findViewById(R.id.etObra)
        val etDonoObra: EditText = view.findViewById(R.id.etDonoObra)
        val etEntidadeExecutante: EditText = view.findViewById(R.id.etEntidadeExecutante)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_registro, parent, false)
        return RegistroViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegistroViewHolder, position: Int) {
        val registro = registros[position]
        holder.etObra.setText(registro.obra)
        holder.etDonoObra.setText(registro.donoObra)
        holder.etEntidadeExecutante.setText(registro.entidadeExecutante)
    }

    override fun getItemCount(): Int {
        return registros.size
    }
}

data class Registro(
    val obra: String,
    val donoObra: String,
    val entidadeExecutante: String
)
