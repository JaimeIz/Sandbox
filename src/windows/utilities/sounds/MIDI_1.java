package windows.utilities.sounds;

import javax.swing.JPanel;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.FlowLayout;

public class MIDI_1 implements ActionListener {
	private JPanel contentPanel;
	private JTextField instVar;
	private JTextField notaVar;
	private JTextField durVar;
	
	private Sequencer player;
	
	private MIDI_1() {
		
		contentPanel = new JPanel();
		contentPanel.setLayout(null);

		JButton playButton = new JButton("Make a sound");
		playButton.setFocusable(false);
		playButton.setFont(new Font("Dialog", Font.PLAIN, 26));
		playButton.addActionListener(this);
		playButton.setBounds(258, 167, 281, 106);
		contentPanel.add(playButton);

		JPanel IntrumentoPanel = new JPanel();
		IntrumentoPanel.setBounds(157, 310, 213, 96);
		contentPanel.add(IntrumentoPanel);

		JLabel lblInstrumento = new JLabel("Instrumento");
		IntrumentoPanel.add(lblInstrumento);
		lblInstrumento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstrumento.setFont(new Font("Tahoma", Font.PLAIN, 20));

		instVar = new JTextField();
		instVar.setFont(new Font("Dialog", Font.PLAIN, 20));
		instVar.setColumns(10);
		IntrumentoPanel.add(instVar);

		JPanel notaPanel = new JPanel();
		notaPanel.setBounds(423, 310, 213, 96);
		contentPanel.add(notaPanel);

		JLabel lblNota = new JLabel("Nota");
		notaPanel.add(lblNota);
		lblNota.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 20));

		notaVar = new JTextField();
		notaVar.setFont(new Font("Dialog", Font.PLAIN, 20));
		notaVar.setColumns(10);
		notaPanel.add(notaVar);
		
		JPanel duracionPanel = new JPanel();
		duracionPanel.setBounds(289, 416, 213, 96);
		contentPanel.add(duracionPanel);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDuracion.setAlignmentX(0.5f);
		duracionPanel.add(lblDuracion);
		
		durVar = new JTextField();
		durVar.setFont(new Font("Dialog", Font.PLAIN, 20));
		durVar.setColumns(10);
		duracionPanel.add(durVar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int instrumento = Integer.parseInt(instVar.getText());
			int nota = Integer.parseInt(notaVar.getText());
			int dur = Integer.parseInt(durVar.getText());
			makeASound(instrumento, nota, dur);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
	}

	public static JPanel getContentPanel() {
		
		
		MIDI_1 obj = new MIDI_1();
		return obj.contentPanel;

	}

	public void makeASound(int instrumento, int nota, int dur) {
		try {
			player = MidiSystem.getSequencer();
			player.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrumento, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1);
			track.add(changeInstrument);
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, nota, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, nota, 100);
			MidiEvent noteOff = new MidiEvent(b, dur);
			track.add(noteOff);
			
			player.setSequence(seq);
			player.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
