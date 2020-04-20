package guru.springframework.spring5webapp.domain.bootstrap;

import org.springframework.boot.CommandLineRunner;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepository;

public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Author eckhart = new Author ("Eckhart", "Tolle");
		Book newEarth = new Book ("New Earth", "12345");
		Publisher peng = new Publisher ("Penguin", "101 Main", "Dallas", "TX", 75024); 
		eckhart.getBooks().add(newEarth);
		newEarth.getAuthors().add(eckhart);

		
		authorRepository.save(eckhart);
		bookRepository.save(newEarth);
		publisherRepository.save(peng);
		
		Author rod = new Author ("Rod", "Johnson");
		Book j2ee = new Book ("J2EE Developer Without EJB", "234234234");
		Publisher tech = new Publisher ("Tech Publisher", "1000 Tech St", "Frisco", "TX", 75025); 
		rod.getBooks().add(j2ee);
		j2ee.getAuthors().add(rod);
		
		authorRepository.save(rod);
		bookRepository.save(j2ee);
		publisherRepository.save(tech);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number ofBooks" + bookRepository.count());
		System.out.println("Number of Publisher" + publisherRepository.count());
		
	}

}
