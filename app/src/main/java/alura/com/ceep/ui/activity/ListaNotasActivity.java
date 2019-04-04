package alura.com.ceep.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import alura.com.ceep.R;
import alura.com.ceep.dao.NotaDAO;
import alura.com.ceep.model.Nota;
import alura.com.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

public class ListaNotasActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Notas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        setTitle(TITULO_APPBAR);
        List<Nota> todasNotas = notasDeExemplo();
        configuraRecyclerView(todasNotas);
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();

        dao.insere(new Nota("Primeira nota", "Primeira escrição"));
        dao.insere((new Nota("Segunda nota", "Segunda descrição com mais conteúdo")));
        dao.insere((new Nota("Anotações", "Gradle, Kotlin e Programação")));
        dao.insere((new Nota("Tópicos para estudo", "Aprender sobre técnicas para programar melhor")));
        dao.insere((new Nota("Programação", "Java, Android, Python")));
        dao.insere((new Nota("Jogos para comprar", "Overwatch e The Witcher")));

        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configuraAdapter(todasNotas, listaNotas);
        configuraLayoutManager(listaNotas);
    }

    private void configuraLayoutManager(RecyclerView listaNotas) {
        //o Layout Manager também pode ser configurado diretamente no layout XML
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listaNotas.setLayoutManager(layoutManager);
    }

    private void configuraAdapter(List<Nota> todasNotas, RecyclerView listaNotas) {
        listaNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
    }
}
