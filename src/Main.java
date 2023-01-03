import br.com.odemur.bootcamp.domain.Bootcamp;
import br.com.odemur.bootcamp.domain.Course;
import br.com.odemur.bootcamp.domain.Dev;
import br.com.odemur.bootcamp.domain.Mentoring;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.setTitle("Java Course");
        course1.setDescription("Java course description...");
        course1.setHours(8);

        Course course2 = new Course();
        course2.setTitle("HTML Course");
        course2.setDescription("HTML course description...");
        course2.setHours(4);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java Mentoring");
        mentoring.setDescription("Java mentoring description...");
        mentoring.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Java Developer Bootcamp");
        bootcamp.setDescription("Bootcamp description...");
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(course2);
        bootcamp.getContents().add(mentoring);

        Dev devJohn = new Dev();
        devJohn.setName("John");
        devJohn.subscribeBootcamp(bootcamp);
        System.out.println("Conteúdos:" + devJohn.getStartedContent());
        devJohn.progress();
        devJohn.progress();
        System.out.println("-");
        System.out.println("Conteúdos:" + devJohn.getStartedContent());
        System.out.println("Conteúdos:" + devJohn.getEndedContent());
        System.out.println("XP:" + devJohn.calculateXP());

        Dev devMary = new Dev();
        devMary.setName("Joao");
        devMary.subscribeBootcamp(bootcamp);
        System.out.println("Conteúdos:" + devMary.getStartedContent());
        devMary.progress();
        devMary.progress();
        devMary.progress();
        System.out.println("-");
        System.out.println("Conteúdos:" + devMary.getStartedContent());
        System.out.println("Conteúdos:" + devMary.getEndedContent());
        System.out.println("XP:" + devMary.calculateXP());
    }

}
