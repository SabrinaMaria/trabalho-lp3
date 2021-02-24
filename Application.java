package com.trabalho.lp3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.trabalho.lp3.Application;

@SpringBootApplication
public class Application {
	String[] periodos = { "meses", "anos" };
	private VeterinarioRepository repoVt;
	private PacienteRepository repoPc;

	private JTextField txtNomePaciente = new JTextField();
	private JTextField txtTutor = new JTextField();
	private JTextField txtIdade = new JTextField();
	private JComboBox cbPeriodo = new JComboBox(periodos);
	private JTextField txtEspecie = new JTextField();
	private JTextField txtBuscaTutor = new JTextField();
	private JTextField txtBuscaEspecie = new JTextField();
	private JButton btCadastrarPaciente = new JButton("Salvar");
	private JButton btListarPaciente = new JButton("Listar");
	private JButton btBuscarPaciente = new JButton("Buscar");

	private JTextField txtNomeVet = new JTextField();
	private JTextField txtCpfVet = new JTextField();
	private JFormattedTextField ftDataNascVet = new JFormattedTextField("DD/MM/AAAA");
	private JTextField txtTempoExperiencia = new JTextField();
	private JTextField txtBuscaNome = new JTextField();
	private JTextField txtBuscaExperienciaMin = new JTextField();
	private JTextField txtBuscaExperienciaMax = new JTextField();
	private JButton btCadastrarVet = new JButton("Salvar");
	private JButton btListarVet = new JButton("Listar");
	private JButton btBuscarVet = new JButton("Buscar");

	private JTextField txtValor = new JTextField();
	private JTextField txtObservacoes = new JTextField();
	private JTextField txtHorario = new JTextField();
	private JFormattedTextField ftDataAtendimento = new JFormattedTextField("DD/MM/AAAA");
	private JComboBox cbPacientes = new JComboBox();
	private DefaultListModel model = new DefaultListModel();
	private JList<Veterinario> jlVeterinarios = new JList(model);
	private JTextField txtBuscaObservacoes = new JTextField();
	private JTextField txtBuscaValorMin = new JTextField();
	private JTextField txtBuscaValorMax = new JTextField();
	private JButton btCadastrarAtendimento = new JButton("Salvar");
	private JButton btListarAtendimento = new JButton("Listar");
	private JButton btBuscarAtendimento = new JButton("Buscar");

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
		builder.headless(false);
		builder.run(args);
	}

	private JFrame criaUIPaciente() {
		JFrame janela = new JFrame("Paciente");
		janela.setSize(480, 320);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(0, 1));

		JLabel lblPeriodo = new JLabel("Período:");
		JLabel lblNome = new JLabel("Nome:");
		JLabel lblIdade = new JLabel("Idade:");
		JLabel lblEspecie = new JLabel("Espécie:");
		JLabel lblTutor = new JLabel("Tutor:");
		JLabel lblBuscaEspecie = new JLabel("Buscar por espécie:");
		JLabel lblBuscaTutor = new JLabel("Buscar por tutor:");

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
		painel.add(lblBuscaTutor);
		painel.add(txtBuscaTutor);
		painel.add(lblBuscaEspecie);
		painel.add(txtBuscaEspecie);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrarPaciente);
		painel.add(btListarPaciente);
		painel.add(btBuscarPaciente);

		janela.getContentPane().setLayout(new BorderLayout());

		janela.getContentPane().add(painel, BorderLayout.CENTER);

		janela.revalidate();

		return janela;
	}

	private JFrame criaUIVet() {
		JFrame janela = new JFrame("Veterinário");
		janela.setSize(480, 320);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(0, 1));

		JLabel lblNomeVet = new JLabel("Nome:");
		JLabel lblDataNasc = new JLabel("Data de nascimento:");
		JLabel lblTempoExperiencia = new JLabel("Tempo de experiência:");
		JLabel lblCpf = new JLabel("CPF:");
		JLabel lblBuscaNome = new JLabel("Buscar por nome:");
		JLabel lblBuscaExperienciaMin = new JLabel("Buscar por experiência (mínima):");
		JLabel lblBuscaExperienciaMax = new JLabel("Buscar por experiência (máxima):");

		painel.add(lblNomeVet);
		painel.add(txtNomeVet);
		painel.add(lblDataNasc);
		painel.add(ftDataNascVet);
		painel.add(lblTempoExperiencia);
		painel.add(txtTempoExperiencia);
		painel.add(lblCpf);
		painel.add(txtCpfVet);
		painel.add(lblBuscaNome);
		painel.add(txtBuscaNome);
		painel.add(lblBuscaExperienciaMin);
		painel.add(txtBuscaExperienciaMin);
		painel.add(lblBuscaExperienciaMax);
		painel.add(txtBuscaExperienciaMax);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrarVet);
		painel.add(btListarVet);
		painel.add(btBuscarVet);

		janela.getContentPane().setLayout(new BorderLayout());

		janela.getContentPane().add(painel, BorderLayout.CENTER);

		janela.revalidate();

		return janela;
	}

	private JFrame criaUIAtendimento() {
		JFrame janela = new JFrame("Atendimento");
		janela.setSize(480, 320);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		JPanel painel = new JPanel();
		painel.setLayout(new GridLayout(0, 1));

		JLabel lblPacientes = new JLabel("Paciente:");
		JLabel lblVeterinarios = new JLabel("Veterinários:");
		JLabel lblData = new JLabel("Data:");
		JLabel lblHorario = new JLabel("Horário:");
		JLabel lblValor = new JLabel("Valor:");
		JLabel lblObservacoes = new JLabel("Observações:");
		JLabel lblBuscaObservacoes = new JLabel("Buscar por observações:");
		JLabel lblBuscaValorMin = new JLabel("Buscar por valor (mínimo):");
		JLabel lblBuscaValorMax = new JLabel("Buscar por valor (máximo):");

		painel.add(lblPacientes);
		painel.add(cbPacientes);
		painel.add(lblVeterinarios);

		JScrollPane scroll = new JScrollPane(jlVeterinarios);

		painel.add(scroll);

		painel.add(lblData);
		painel.add(ftDataAtendimento);
		painel.add(lblHorario);
		painel.add(txtHorario);
		painel.add(lblValor);
		painel.add(txtValor);
		painel.add(lblObservacoes);
		painel.add(txtObservacoes);
		painel.add(lblBuscaObservacoes);
		painel.add(txtBuscaObservacoes);
		painel.add(lblBuscaValorMin);
		painel.add(txtBuscaValorMin);
		painel.add(lblBuscaValorMax);
		painel.add(txtBuscaValorMax);

		painel.add(new JLabel());
		painel.add(new JLabel());

		painel.add(btCadastrarAtendimento);
		painel.add(btListarAtendimento);
		painel.add(btBuscarAtendimento);

		janela.getContentPane().setLayout(new BorderLayout());

		janela.getContentPane().add(painel, BorderLayout.CENTER);

		jlVeterinarios.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("== SELECIONADOS == ");

				List<Veterinario> selecionados = jlVeterinarios.getSelectedValuesList();

				for (Veterinario v : selecionados) {
					System.out.println(v.getNome());
				}
			}
		});

		janela.revalidate();

		return janela;
	}

	@Bean
	public PacienteRepository runPaciente(PacienteRepository pc) {
		
		this.repoPc = pc;

		criaUIPaciente();

		populaPacientes();

		btBuscarPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String buscaPorTutor = txtBuscaTutor.getText();
				String buscaPorEspecie = txtBuscaEspecie.getText();
				
				List<Paciente> pacientes1 = pc.findByTutor(buscaPorTutor);
				List<Paciente> pacientes2 = pc.findByEspecie(buscaPorEspecie);

				System.out.println("Busca por tutor:");
				for (Paciente p : pacientes1) {
					System.out.println(p);
				}
				
				System.out.println("Busca por espécie:");
				for (Paciente p : pacientes2) {
					System.out.println(p);
				}
			}

		});

		btListarPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Paciente> pacientes = pc.findAll();

				for (Paciente p : pacientes) {
					System.out.println(p);
				}
			}

		});

		btCadastrarPaciente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txtNomePaciente.getText();
				String idade = txtIdade.getText();
				String periodo = (String) cbPeriodo.getSelectedItem();
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

	private void populaPacientes() {
		List<Paciente> pcs = repoPc.findAll();

		for (int i = 0; i < pcs.size(); i++) {
			cbPacientes.addItem(pcs.get(i));
		}
	}

	@Bean
	public VeterinarioRepository runVeterinario(VeterinarioRepository vt) {

		this.repoVt = vt;

		criaUIVet();

		populaVeterinarios();
		
		btBuscarVet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String buscaPorNome = txtBuscaNome.getText();
				Integer buscaPorExperienciaMin = Integer.parseInt(txtBuscaExperienciaMin.getText());
				Integer buscaPorExperienciaMax = Integer.parseInt(txtBuscaExperienciaMax.getText());
				
				List<Veterinario> veterinarios1 = vt.findByNome(buscaPorNome);
				List<Veterinario> veterinarios2 = vt.findByTempoExperienciaBetween(buscaPorExperienciaMin, buscaPorExperienciaMax);

				System.out.println("Busca por nome:");
				for (Veterinario v : veterinarios1) {
					System.out.println(v);
				}
				
				System.out.println("Busca por experiência:");
				for (Veterinario v : veterinarios2) {
					System.out.println(v);
				}
			}

		});

		btListarVet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Veterinario> veterinarios = vt.findAll();

				for (Veterinario v : veterinarios) {
					System.out.println(v);
				}
			}

		});

		btCadastrarVet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = txtNomeVet.getText();
				String tempoExperiencia = txtTempoExperiencia.getText();
				String cpf = txtCpfVet.getText();
				Date dataNasc = null;

				try {
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date dataConvertida = df.parse(ftDataNascVet.getText());
					dataNasc = new Date(dataConvertida.getTime());
				} catch (Exception e1) {
					System.out.println("Erro convertendo a data");
					e1.printStackTrace();
				}

				Veterinario v = new Veterinario();

				v.setNome(nome);
				v.setTempoExperiencia(Integer.parseInt(tempoExperiencia));
				v.setDataNasc(dataNasc);
				v.setCpf(cpf);

				vt.save(v);

				JOptionPane.showMessageDialog(null, "Veterinário cadastrado");
			}
		});

		return vt;
	}

	private void populaVeterinarios() {
		List<Veterinario> lista = repoVt.findAll();

		for (Veterinario v : lista) {
			model.addElement(v);
		}
	}

	@Bean
	public AtendimentoRepository runAtendimento(AtendimentoRepository at) {

		criaUIAtendimento();

		btBuscarAtendimento.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float valorMin = Float.parseFloat(txtBuscaValorMin.getText());
				float valorMax = Float.parseFloat(txtBuscaValorMax.getText());
				String observacoes = txtBuscaObservacoes.getText();
				
				List<Atendimento> atendimentos1 = at.findByValorBetween(valorMin, valorMax);
				List<Atendimento> atendimentos2 = at.findByObservacoes(observacoes);

				System.out.println("Busca por valor:");
				for (Atendimento a : atendimentos1) {
					System.out.println(a);
				}
				
				System.out.println("Busca por observações:");
				for (Atendimento a : atendimentos2) {
					System.out.println(a);
				}
			}

		});
		
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
				String horario = txtHorario.getText();

				try {
					SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date dataConvertida2 = df2.parse(ftDataAtendimento.getText());
					data = new Date(dataConvertida2.getTime());
				} catch (Exception e1) {
					System.out.println("Erro convertendo a data");
					e1.printStackTrace();
				}

				Atendimento a = new Atendimento();

				a.setValor(Float.parseFloat(valor));
				a.setObservacoes(observacoes);
				a.setData(data);
				a.setHorario(horario);

				a = at.save(a);

				Paciente pac = (Paciente) cbPacientes.getSelectedItem();
				pac.getAtendimentos().add(a);

				a.setPaciente((Paciente) cbPacientes.getSelectedItem());

				for (Veterinario vet : jlVeterinarios.getSelectedValuesList()) {
					vet.getAtendimentos().add(a);
				}

				a.setVeterinarios(jlVeterinarios.getSelectedValuesList());

				at.save(a);

				JOptionPane.showMessageDialog(null, "Atendimento cadastrado");
			}
		});

		return at;
	}
}
