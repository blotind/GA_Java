import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.Utils;

public class Main implements ActionListener {
	String sentence;
	int[] answerArray;
	JButton button;
	JTextField tfield;
	Citizen[] population;
	boolean bStop = false;

	int popSize = 100;

	/**
	 * Constructor
	 */
	public Main() {
		init();
		initGUI();
	}

	/**
	 * Makes the UI
	 */
	private void initGUI() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();

		JPanel panel = new JPanel();
		panel.setLayout(layout);
		button = new JButton("push it real good");
		button.addActionListener(this);
		tfield = new JTextField();

		panel.add(button, BorderLayout.NORTH);
		panel.add(tfield, BorderLayout.CENTER);

		frame.add(panel);
		frame.setSize(500, 500);
		frame.pack();
		frame.setVisible(true);

	}

	/**
	 * Things get initialised here when the code is executed.
	 */
	private void init() {
		// System.out.println("random number is: " + Utils.RandomNumberGen());
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			sentence = tfield.getText();
			System.out.println(sentence);
			Utils.AnswerRepresentation(sentence);

			answerArray = Utils.AnswerRepresentation(sentence);

			InnitGA();
		}
	}

	/**
	 * Recipe for GA
	 */
	private void InnitGA() {
		 Mutate();
	}

	/**
	 * 
	 */
	private void Mutate() {
		int iterator = 0;
		while (!bStop) {
			Spawn();
			rateStrength();
			Dump();
			iterator++;
			System.out.println("iterator: " + iterator);
		}
	}

	/**
	 * Creates the population
	 */
	private void Spawn() {
		int sentLength = sentence.length();
		population = new Citizen[popSize];
		for (int i = 0; i < popSize; i++) {
			population[i] = new Citizen(sentLength);
		}
	}

	/**
	 * Set each Citizens strength
	 */
	private void rateStrength() {
		
		for (int i = 0; i < popSize; i++) {
			int unitsCorrect = 0;
			for (int k = 0; k < answerArray.length; k++) {
				if (population[i].dataArr[k] == answerArray[k]) {
					unitsCorrect++;
				}
			}
			population[i].setStrength(unitsCorrect);
			if (unitsCorrect == answerArray.length) {
				bStop = true;
				System.out.println("There was a winner: " + i);
				System.out.println("Winner is: " + population[i].toString());
			}
		}

	}

	/**
	 * Dumps the current population in it's entirety
	 */
	private void Dump() {
		for (int i = 0; i < population.length; i++) {
			System.out.println(poptoString(i) + " " + Arrays.toString(Utils.AsciiTochar(population[i].dataArr)));
		}
	}

	/**
	 * Gets the String representation of a member of the population by ID
	 * 
	 * @param citizenID
	 * @return String representation of each member of the population
	 */
	private String poptoString(int citizenID) {
		return population[citizenID].toString();
	}

}
