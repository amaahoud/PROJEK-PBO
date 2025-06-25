package com.reservasi.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import com.reservasi.db.DatabaseConnection;

public class ReservationForm extends JFrame {
    // Komponen GUI
    private JLabel studentIdLabel, courseIdLabel, instructorIdLabel, dateLabel, timeLabel;
    private JTextField studentIdField, courseIdField, instructorIdField, dateField, timeField;
    private JButton submitButton;

    public ReservationForm() {
        // Pengaturan dasar frame
        setTitle("Form Reservasi Kelas Privat");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Menempatkan frame di tengah layar

        // Membuat panel untuk menampung komponen
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // GridLayout dengan 6 baris, 2 kolom, dan jarak 10px
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        // Inisialisasi komponen
        studentIdLabel = new JLabel("ID Siswa:");
        studentIdField = new JTextField();
        courseIdLabel = new JLabel("ID Kursus:");
        courseIdField = new JTextField();
        instructorIdLabel = new JLabel("ID Instruktur:");
        instructorIdField = new JTextField();
        dateLabel = new JLabel("Tanggal Reservasi (YYYY-MM-DD):");
        dateField = new JTextField();
        timeLabel = new JLabel("Waktu Reservasi (HH:MM:SS):");
        timeField = new JTextField();
        submitButton = new JButton("Submit Reservasi");

        // Menambahkan komponen ke panel
        panel.add(studentIdLabel);
        panel.add(studentIdField);
        panel.add(courseIdLabel);
        panel.add(courseIdField);
        panel.add(instructorIdLabel);
        panel.add(instructorIdField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(new JLabel()); // Placeholder untuk mengisi grid
        panel.add(submitButton);

        // Menambahkan panel ke frame
        add(panel);

        // Menambahkan ActionListener ke tombol submit
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitReservation();
            }
        });
    }

    private void submitReservation() {
        // Mengambil data dari field input
        int studentId = Integer.parseInt(studentIdField.getText());
        int courseId = Integer.parseInt(courseIdField.getText());
        int instructorId = Integer.parseInt(instructorIdField.getText());
        Date reservationDate = Date.valueOf(dateField.getText());
        Time reservationTime = Time.valueOf(timeField.getText());
        String status = "Pending"; // Status default

        // Mendapatkan koneksi database
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DatabaseConnection.getConnection();
            // Query SQL untuk insert data reservasi
            String sql = "INSERT INTO reservations (student_id, course_id, instructor_id, reservation_date, reservation_time, status) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            // Mengatur parameter PreparedStatement
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, courseId);
            pstmt.setInt(3, instructorId);
            pstmt.setDate(4, reservationDate);
            pstmt.setTime(5, reservationTime);
            pstmt.setString(6, status);

            // Mengeksekusi query
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Reservasi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                // Mengosongkan field setelah berhasil disimpan
                studentIdField.setText("");
                courseIdField.setText("");
                instructorIdField.setText("");
                dateField.setText("");
                timeField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Reservasi gagal disimpan.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input ID harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Format tanggal atau waktu salah! Gunakan YYYY-MM-DD dan HH:MM:SS.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            // Menutup PreparedStatement dan Connection
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Menjalankan GUI di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReservationForm().setVisible(true);
            }
        });
    }
}