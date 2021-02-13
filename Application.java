package com.trabalho.lp3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.trabalho.lp3.Application;

@SpringBootApplication
public class Application {
//	List<String> vets;
//	
//	@Bean
//	public VeterinarioRepository run(VeterinarioRepository vt) {
//		List<Veterinario> veterinarios = vt.findAll();
//		
//		for (Veterinario v: veterinarios) {
//			vets.add(v.getNome());
//		}
//		
//		return vt;
//	}

	private JTextField txtNome = new JTextField();
	private JTextField txtTutor = new JTextField();
	private JTextField txtIdade = new JTextField();
	private JFormattedTextField ftPeriodo = new JFormattedTextField("anos");
	private JTextField txtEspecie = new JTextField();
	private JButton btCadastrar = new JButton("Salvar");
	private JButton btListar = new JButton("Listar");

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.headless(false);
		builder.run(args);
	}

	private JFrame criaUI() {
		JFrame janela = new JFrame("Paciente");
		janela.setSize(480, 320);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(0, 1));

		JLabel lblPeriodo = new JLabel("Período:");
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblEspecie = new JLabel("Espécie:");
		JLabel lblTutor = new JLabel("Tutor:");

		painel.add(lblNome);
		painel.add(txtNome);
		painel.add(lblIdade);
		painel.add(txtIdade);
		painel.add(lblPeriodo);
		painel.add(ftPeriodo);
		painel.add(lblEspecie);
		painel.add(txtEspecie);
		painel.add(lblTutor);
		painel.add(txtTutor);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrar);
		painel.add(btListar);

		janela.getContentPane().setLayout(new BorderLayout());

		janela.getContentPane().add(painel, BorderLayout.CENTER);

		janela.revalidate();

		return janela;
	}

	@Bean
//	public PacienteRepository run(PacienteRepository pc) {
//		List<Paciente> pacientes = pc.findByTutor("sabrina");
//		List<Paciente> pacientes = pc.findByEspecie("gato");
//		
//		for (Paciente p: pacientes) {
//			System.out.println(p);
//		}
//		
//		return pc;
//	}
	
//	public VeterinarioRepository run(VeterinarioRepository vt) {
//		List<Veterinario> veterinarios = vt.findByNome("luana");
//		List<Veterinario> veterinarios = vt.findByTempoExperienciaBetween(3, 5);
//		
//		for (Veterinario v: veterinarios) {
//			System.out.println(v);
//		}
//		
//		return vt;
//	}
//	
	public PacienteRepository run(PacienteRepository pc) {
		
		criaUI();
		
		btListar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Paciente> pacientes = pc.findAll();
				
				for (Paciente p: pacientes) {
					System.out.println(p);
				}
			}
			
		});

		btCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String idade = txtIdade.getText();
				String periodo = ftPeriodo.getText();
				String especie = txtEspecie.getText();
				String tutor = txtTutor.getText();
				
				Paciente p = new Paciente();
				
				p.setNome(nome);
				p.setIdade(Integer.parseInt(idade));
				p.setPeriodo(periodo);
				p.setEspecie(especie);
				p.setTutor(tutor);
				
				pc.save(p);
				
				JOptionPane.showMessageDialog(null, "Paciente cadastrado");
			}
		});
		
		return pc;
	}
}
