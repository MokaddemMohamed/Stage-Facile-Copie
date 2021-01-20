package com.projet.annuaire.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.Field;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.User;
import com.projet.annuaire.repository.EnterpriseRepository;
import com.projet.annuaire.repository.FieldRepository;
import com.projet.annuaire.repository.StageRepository;
import com.projet.annuaire.repository.TutorRepository;
import com.projet.annuaire.service.UserService;
/**
 * 
 * @author LE Dan
 *
 */
public class ReadData {
	private TutorRepository tutorRepository;
	private EnterpriseRepository enterpriseRepository;
	private UserService userService;
	private FieldRepository fieldRepository;
	private StageRepository stageRepository;
	private List<String> lines;

	public ReadData(TutorRepository tutorRepository, UserService userService, EnterpriseRepository enterpriseRepository,
			FieldRepository fieldRepository, StageRepository stageRepository) {
		this.tutorRepository = tutorRepository;
		this.userService = userService;
		this.enterpriseRepository = enterpriseRepository;
		this.fieldRepository = fieldRepository;
		this.stageRepository = stageRepository;
		lines = new ArrayList<String>();
	}

	/**
	 * Load data with fileName parse by \t
	 * 
	 * @param fileName Name of filename
	 * @throws IOException
	 */
	public void loadData(String fileName, String fieldName) throws IOException {
		int i = 0;
		String[] line;
		String[] name;
		String[] number;
		String startDate;
		String dateEnd;
		String administrator;
		float salaire = 0;

		GeneratorUsers g = new GeneratorUsers();
		GeneratorTutor t = new GeneratorTutor();
		GeneratorEnterprises e = new GeneratorEnterprises();
		GeneratorStage st = new GeneratorStage();
		Enterprise enterprise = new Enterprise();
		User user = new User();
		Tutor tutor = new Tutor();
		Field field = new Field();
		Stage stage = new Stage();
		int ag = 0;
		readFile(lines, fileName);

		for (String s : lines) {
			line = s.split("\t");
			// Split firstName and lastName
			name = line[2].split(" ");
			ag++;

			// Convert date
			startDate = convertirDate(line[17]);
			dateEnd = convertirDate(line[18]);
			// generate user
			// check if he exist in User with number/firstName/Lastname, if he don't exist
			// create him
			if (userService.findBytel(line[3]) == null && userService.findByFirstName(name[1]) == null
					&& userService.findByLastName(name[0]) == null) {
				userService.save(g.loadUser(name[1], name[0], line[3]));
			}
			// generate tutor
			// check if he exist in tutor with number/mail, if he don't exist create him
			if (tutorRepository.findByPhoneNumber(line[16]) == null && tutorRepository.findByMail(line[15]) == null) {
				tutorRepository.save(t.loadTutor(line[14], line[13], line[15], line[16]));
			}
			// generate enterprise
			// check if he exist in enterprise with name/adress/postal, if he don't exist
			// create him
			if (enterpriseRepository.findByName(line[9]) == null
					&& enterpriseRepository.findByPostalCode(line[11]) == null)
				enterpriseRepository.save(e.loadEnterprise(line[9], line[10], line[11], line[12], line[7]));
			// generate traineeship
			// recover enterprise, user, tutor, field
			// Create if he don't exist
			if (stageRepository.findBySubject(line[6]) == null) {

				enterprise = enterpriseRepository.findByPostalCode(line[11]);
				tutor = tutorRepository.findByPhoneNumber(line[16]);
				field = fieldRepository.findByTitle(fieldName);
				user = userService.findByUsername(name[1] + "." + name[0] + "@etu.univ-amu.fr");

				if (line.length != 23)
					administrator = "";
				else
					administrator = line[22];
				// check if we are gratification
				if (line.length > 19) {

					// calculate gratification for $/months
					if (line[19].length() != 0) {

						if (line[19].indexOf(',') != -1) {

							number = line[19].split(",");
							stage = st.loadStage(line[0], line[1], startDate, dateEnd, line[6], line[5],
									Float.parseFloat(number[0] + "." + number[1]), line[4], line[8], enterprise, user,
									tutor, field, administrator);
						} else {
							stage = st.loadStage(line[0], line[1], startDate, dateEnd, line[6], line[5],
									Float.parseFloat(line[19]), line[4], line[8], enterprise, user, tutor, field,
									administrator);
						}
					} else if (line[20].length() != 0) {

						number = line[20].split(",");
						salaire = 5 * Float.parseFloat(number[0] + "." + number[1]) * 4;
						stage = st.loadStage(line[0], line[1], startDate, dateEnd, line[6], line[5], salaire, line[4],
								line[8], enterprise, user, tutor, field, administrator);
					} else if (line[21].length() != 0) {

						number = line[21].split(",");
						salaire = 35 * Float.parseFloat(number[0] + "." + number[1]) * 4;
						stage = st.loadStage(line[0], line[1], startDate, dateEnd, line[6], line[5], salaire, line[4],
								line[8], enterprise, user, tutor, field, administrator);

					} else {
						stage = st.loadStage(line[0], line[1], startDate, dateEnd, line[6], line[5], 0, line[4],
								line[8], enterprise, user, tutor, field, administrator);
					}
				} else {
					stage = st.loadStage(line[0], line[1], startDate, dateEnd, line[6], line[5], 0, line[4], line[8],
							enterprise, user, tutor, field, administrator);
				}
				stageRepository.save(stage);
				i++;
			}
		}

	}

	/**
	 * Read a file
	 * 
	 * @param file entity file
	 * @param path entity path
	 * @return list of words
	 * @throws IOException
	 */
	public String[] readFile(List<String> a, String path) throws IOException {
		BufferedReader IN = new BufferedReader(new FileReader(path));
		String ligne;
		String[] mot = null;
		while ((ligne = IN.readLine()) != null) {
			mot = ligne.split(" ");
			a.add(ligne);
		}
		return mot;

	}

	/**
	 * convert date
	 * 
	 * @param line date like 1 mars 2000
	 * @return date
	 */
	public String convertirDate(String line) {
		String convertis = "";
		String[] tmp;

		tmp = line.split(" ");
		tmp[0] = "01";
		switch (tmp[1]) {
		case "janvier":
			tmp[1] = "01";
			break;
		case "février":
			tmp[1] = "02";
			break;
		case "mars":
			tmp[1] = "03";
			break;
		case "avril":
			tmp[1] = "04";
			break;
		case "mai":
			tmp[1] = "05";
			break;
		case "juin":
			tmp[1] = "06";
			break;
		case "juillet":
			tmp[1] = "07";
			break;
		case "août":
			tmp[1] = "08";
			break;
		case "septembre":
			tmp[1] = "09";
			break;
		case "octobre":
			tmp[1] = "10";
			break;
		case "novembre":
			tmp[1] = "11";
			break;
		case "décembre":
			tmp[1] = "12";
			break;
		}
		convertis = tmp[2] + "-" + tmp[1] + "-" + tmp[0];
		return convertis;
	}
}
