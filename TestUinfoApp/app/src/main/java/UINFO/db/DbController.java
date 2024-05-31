package UINFO.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import UINFO.Models.Kampus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DbController {

    public ObservableList<Kampus> getdetailuniv(String NamaKampus) {
        String sql = "SELECT * FROM DESKRIPSIUNIV WHERE Kampus = ?";
        ObservableList<Kampus> data = FXCollections.observableArrayList();

        try (Connection conn = DbConfig.connect();
		 	PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, NamaKampus);
			ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Kampus kampus = new Kampus(
                        rs.getInt("id"),
                        rs.getString("Kampus"),
                        rs.getString("Fakultas"),
                        rs.getString("Jurusan"),
                        rs.getString("Biaya Pangkal"),
                        rs.getString("Biaya Kuliah Tunggal"),
                        rs.getString("Gol. UKT 1-3"),
                        rs.getString("Gol. UKT 4-6"),
                        rs.getString("Gol. UKT 7-8"),
                        rs.getString("Alamat"),
                        rs.getString("Status"),
                        rs.getString("Biaya Pendaftaran"),
                        rs.getString("Jalur Pendaftaran")
                );
                data.add(kampus);
            }
			}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
        return data;

    }
}