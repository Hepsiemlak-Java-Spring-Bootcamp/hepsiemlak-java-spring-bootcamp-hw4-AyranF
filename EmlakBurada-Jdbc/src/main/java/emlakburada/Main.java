package emlakburada;

import java.util.List;

import emlakburada.dao.AdvertRepository;
import emlakburada.dao.UserRepository;
import emlakburada.entity.Advert;
import emlakburada.entity.User;

public class Main {

	public static void main(String[] args) {

		AdvertRepository advertRepository = new AdvertRepository();
		advertRepository.save(prepareAdvert(1, 1231231, 1, "Ucuz"));
		advertRepository.save(prepareAdvert(2, 1231232, 1, "Acil"));
		advertRepository.save(prepareAdvert(3, 1231233, 1, "Satılık"));
		advertRepository.save(prepareAdvert(4, 1231234, 1, "Kiralık"));
		advertRepository.save(prepareAdvert(5, 1231235, 1, "Baslik"));
		System.out.println("--find all advert--");

		List<Advert> Adverts = advertRepository.findAll();

		Adverts.stream().forEach(adverts -> System.out.println(Adverts.toString()));

		System.out.println("--find advert--");

		Advert foundAdvert = advertRepository.findOne(2);

		System.out.println(foundAdvert.toString());
		

		System.out.println("-------------------------------------");
		
		
		UserRepository userRepository = new UserRepository();
		userRepository.save(prepareUser(1, "cem"));
		userRepository.save(prepareUser(2, "emir"));
		userRepository.save(prepareUser(3, "nehir"));
		userRepository.save(prepareUser(4, "melike"));
		userRepository.save(prepareUser(5, "serra"));
		
		System.out.println("--find all user--");

		List<User> users = userRepository.findAll();

		users.stream().forEach(user -> System.out.println(user.toString()));

		System.out.println("--find user--");

		User foundUser = userRepository.findOne(2);

		System.out.println(foundUser.toString());

	}

	private static User prepareUser(int id, String name) {
		User user = new User();
		user.id = id;
		user.name = name;
		user.email = "cemdrman@gmail.com";
		user.bio = "bio";
		return user;
	}
	private static Advert prepareAdvert(int id, int advertNo, int creatorId, String baslik) {
		return new Advert(id, advertNo, creatorId, baslik);
	}

}