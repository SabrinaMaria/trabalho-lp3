package com.trabalho.lp3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.trabalho.lp3.Application;

@SpringBootApplication
public class Application {
	String[] periodos = {"meses", "anos"};
	String[] pacientes = {};
	
	private JTextField txtNomePaciente = new JTextField();
	private JTextField txtTutor = new JTextField();
	private JTextField txtIdade = new JTextField();
	private JComboBox cbPeriodo = new JComboBox(periodos);
	private JTextField txtEspecie = new JTextField();
	private JButton btCadastrarPaciente = new JButton("Salvar");
	private JButton btListarPaciente = new JButton("Listar");

	private JTextField txtNomeVet = new JTextField();
	private JTextField txtCpfVet = new JTextField();
	private JFormattedTextField ftDataNascVet = new JFormattedTextField("DD/MM/AAAA");
	private JTextField txtTempoExperiencia = new JTextField();
	private JButton btCadastrarVet = new JButton("Salvar");
	private JButton btListarVet = new JButton("Listar");

	private JTextField txtValor = new JTextField();
	private JTextField txtObservacoes = new JTextField();
	private JFormattedTextField ftDataAtendimento = new JFormattedTextField("DD/MM/AAAA");
	private JComboBox cbPacientes = new JComboBox(pacientes);
//	private DefaultListModel model = new DefaultListModel();
//	private JList list = new JList(model);
	private JButton btCadastrarAtendimento = new JButton("Salvar");
	private JButton btListarAtendimento = new JButton("Listar");

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.headless(false);
		builder.run(args);
	}

	private JFrame criaUIPaciente() {
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
		painel.add(txtNomePaciente);
		painel.add(lblIdade);
		painel.add(txtIdade);
		painel.add(lblPeriodo);
		painel.add(cbPeriodo);
		painel.add(lblEspecie);
		painel.add(txtEspecie);
		painel.add(lblTutor);
		painel.add(txtTutor);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrarPaciente);
		painel.add(btListarPaciente);

		janela.getContentPane().setLayout(new BorderLayout());

		janela.getContentPane().add(painel, BorderLayout.CENTER);

		janela.revalidate();

		return janela;
	}

	private JFrame criaUIVet() {
		JFrame janela = new JFrame("Veterinário");
		janela.setSize(480, 320);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(0, 1));

		JLabel lblNomeVet = new JLabel("Nome:");
		JLabel lblDataNasc = new JLabel("Data de nascimento:");
		JLabel lblTempoExperiencia = new JLabel("Tempo de experiência:");
		JLabel lblCpf = new JLabel("CPF:");

		painel.add(lblNomeVet);
		painel.add(txtNomeVet);
		painel.add(lblDataNasc);
		painel.add(ftDataNascVet);
		painel.add(lblTempoExperiencia);
		painel.add(txtTempoExperiencia);
		painel.add(lblCpf);
		painel.add(txtCpfVet);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrarVet);
		painel.add(btListarVet);

		janela.getContentPane().setLayout(new BorderLayout());

		janela.getContentPane().add(painel, BorderLayout.CENTER);

		janela.revalidate();

		return janela;
	}

	private JFrame criaUIAtendimento() {
		JFrame janela = new JFrame("Atendimento");
		janela.setSize(480, 320);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(0, 1));

		JLabel lblPacientes = new JLabel("Paciente:");
		JLabel lblData = new JLabel("Data:");
		JLabel lblValor = new JLabel("Valor:");
		JLabel lblObservacoes = new JLabel("Observações:");

		painel.add(lblPacientes);
		painel.add(cbPacientes);
		painel.add(lblData);
		painel.add(ftDataAtendimento);
		painel.add(lblValor);
		painel.add(txtValor);
		painel.add(lblObservacoes);
		painel.add(txtObservacoes);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrarPaciente);
		painel.add(btListarPaciente);

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
//		criaUIPaciente();
//		
//		btListarPaciente.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				List<Paciente> pacientes = pc.findAll();
//				
//				for (Paciente p: pacientes) {
//					System.out.println(p);
//				}
//			}
//			
//		});
//
//		btCadastrarPaciente.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String nome = txtNomePaciente.getText();
//				String idade = txtIdade.getText();
//				String periodo = (String) cbPeriodo.getSelectedItem();
//				String especie = txtEspecie.getText();
//				String tutor = txtTutor.getText();
//				
//				Paciente p = new Paciente();
//				
//				p.setNome(nome);
//				p.setIdade(Integer.parseInt(idade));
//				p.setPeriodo(periodo);
//				p.setEspecie(especie);
//				p.setTutor(tutor);
//				
//				pc.save(p);
//				
//				JOptionPane.showMessageDialog(null, "Paciente cadastrado");
//			}
//		});
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
//		criaUIVet();
//		
//		btListarVet.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				List<Veterinario> veterinarios = vt.findAll();
//				
//				for (Veterinario v: veterinarios) {
//					System.out.println(v);
//				}
//			}
//			
//		});
//
//		btCadastrarVet.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String nome = txtNomeVet.getText();
//				String tempoExperiencia = txtTempoExperiencia.getText();
//				String cpf = txtCpfVet.getText();
//				Date dataNasc = null;
//
//				try {
//					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//					java.util.Date dataConvertida = df.parse(ftDataNascVet.getText());
//					dataNasc = new Date(dataConvertida.getTime());
//				} catch (Exception e1) {
//					System.out.println("Erro convertendo a data");
//					e1.printStackTrace();
//				}
//				
//				Veterinario v = new Veterinario();
//				
//				v.setNome(nome);
//				v.setTempoExperiencia(Integer.parseInt(tempoExperiencia));
//				v.setDataNasc(dataNasc);
//				v.setCpf(cpf);
//				
//				vt.save(v);
//				
//				JOptionPane.showMessageDialog(null, "Veterinário cadastrado");
//			}
//		});
//		
//		return vt;
//	}

	public AtendimentoRepository run(AtendimentoRepository at) {
//		List<Atendimento> atendimentos = at.findByValorBetween((float) 0, (float) 100);
//		List<Atendimento> atendimentos = at.findByObservacoes("muitas");
//		
//		for (Atendimento a: atendimentos) {
//			System.out.println(a);
//		}

		criaUIAtendimento();

		btListarAtendimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Atendimento> atendimentos = at.findAll();

				for (Atendimento a : atendimentos) {
					System.out.println(a);
				}
			}

		});

		btCadastrarAtendimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String valor = txtValor.getText();
				String observacoes = txtObservacoes.getText();
				Date data = null;
//				Paciente paciente = new Paciente();
//
//				List<Paciente> pcs;
//
//				cbPacientes.getSelectedItem();

				try {
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date dataConvertida = df.parse(ftDataAtendimento.getText());
					data = new Date(dataConvertida.getTime());
				} catch (Exception e1) {
					System.out.println("Erro convertendo a data");
					e1.printStackTrace();
				}

				Atendimento a = new Atendimento();

				a.setValor(Float.parseFloat(valor));
				a.setObservacoes(observacoes);
				a.setDataHora(data);

				at.save(a);

				JOptionPane.showMessageDialog(null, "Atendimento cadastrado");
			}
		});

		return at;
	}

	@Bean
	public PacienteRepository lista(PacienteRepository pc) {
		List<Paciente> pcs = pc.findAll();
		pacientes = new String [pcs.size()];

		for (int i = 0; i < pcs.size(); i++) {
			pacientes[i] = pcs.get(i).getNome();
		}

		return pc;
	}
}
