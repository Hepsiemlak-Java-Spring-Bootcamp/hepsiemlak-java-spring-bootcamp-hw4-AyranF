package emlakburada.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emlakburada.entity.Advert;

public class AdvertRepository extends JdbcConnectionRepository {
	//int id, int advertNo, int creatorUser, String baslik
	private static final String INSERT_ADVERT = "INSERT INTO ADVERT (ID, ADVERT_NO, CREATOR_USER_ID, BASLIK, AKTIF_MI, incelendi_mi,fiyat, one_cikarilsin_mi, suresi) VALUES (?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_ALL_ADVERT = "SELECT * FROM ADVERT";
	private static final String FIND_ADVERT = "SELECT * FROM ADVERT WHERE id = ?";

	public void save(Advert advert) {

		Connection connection = connect();

		if (connection != null) {

			PreparedStatement prepareStatement = null;
			try {

				prepareStatement = connection.prepareStatement(INSERT_ADVERT);
				prepareStatement.setInt(1, advert.id);
				prepareStatement.setInt(2, advert.advertNo);
				prepareStatement.setInt(3, advert.creatorUserId);
				prepareStatement.setString(4, advert.baslik);
				prepareStatement.setBoolean(5, false);
				prepareStatement.setBoolean(6, false);
				prepareStatement.setInt(7, 5555);
				prepareStatement.setBoolean(8, false);
				prepareStatement.setInt(9, 9);
				int executeUpdate = prepareStatement.executeUpdate();

				System.out.println("result: " + executeUpdate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("Connection oluşturululamadı!");
		}

	}

	public List<Advert> findAll() {

		List<Advert> advertList = new ArrayList<Advert>();

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_ADVERT);

			ResultSet result = prepareStatement.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				int advertNo = result.getInt("ADVERT_NO");
				int creatorUser = result.getInt("CREATOR_USER_ID");
				String baslik = result.getString("BASLIK");

				advertList.add(prepareAdvert(id, advertNo, creatorUser, baslik));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return advertList;

	}

	private Advert prepareAdvert(int id, int advertNo, int creatorUserId, String baslik) {
		Advert advert = new Advert();

		advert.id = id;
		advert.advertNo = advertNo;
		advert.creatorUserId = creatorUserId;
		advert.baslik = baslik;

		return advert;
	}

	public Advert findOne(int id) {

		Advert advert = null;

		Connection connection = connect();

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(FIND_ADVERT);
			prepareStatement.setInt(1, id);

			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				int advertid = result.getInt("id");
				int advertNo = result.getInt("ADVERT_NO");
				int creatorUser = result.getInt("CREATOR_USER_ID");
				String baslik = result.getString("BASLIK");

				advert = prepareAdvert(advertid, advertNo, creatorUser, baslik);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return advert;

	}

}