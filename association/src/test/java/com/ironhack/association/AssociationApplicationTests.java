package com.ironhack.association;

import com.ironhack.association.model.Chapter;
import com.ironhack.association.model.Member;
import com.ironhack.association.model.Status;
import com.ironhack.association.repository.ChapterRepository;
import com.ironhack.association.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssociationApplicationTests {


	@Autowired
	private ChapterRepository chapterRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void saveChapters_chapterAndMembers_correctSave() {
		Chapter chapter = new Chapter("Chapter 1 Test", "Madrid");

		Member member1 = new Member("Bob", Status.ACTIVE, LocalDate.of(2025, 8, 20), chapter);

		Member member2 = new Member("John", Status.LAPSED, LocalDate.of(2025, 10, 15), chapter);

		Member president = new Member("Sara", Status.ACTIVE, LocalDate.of(2025, 5, 10), chapter);

		chapter.setPresident(president);
		chapter.getMembers().add(member1);
		chapter.getMembers().add(member2);

		chapterRepository.save(chapter);
		memberRepository.save(president);
		memberRepository.save(member1);
		memberRepository.save(member2);

		Optional<Chapter> chapterOptional = chapterRepository.findById(chapter.getChapterId());
		assertTrue(chapterOptional.isPresent());
	}
}
