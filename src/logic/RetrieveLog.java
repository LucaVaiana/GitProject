package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

public class RetrieveLog {
	public static void main(String[] args) {
		FileRepositoryBuilder builder = new FileRepositoryBuilder();
		try {
		Repository repo = builder.setGitDir(new File("C:/Users/Luca/Desktop/TOR VERGATA MAGISTRALE/ingegneria del software 2/Falessi/esercizi/25-03-2020/GitProject/.git")).setMustExist(true).build();
		Git git = new Git(repo);
		Iterable<RevCommit> log = git.log().call();
		for (Iterator<RevCommit> iterator = log.iterator(); iterator.hasNext();) {
		  RevCommit rev = iterator.next();
		  if (rev.getFullMessage().contains("Added")) {
			  System.out.println(rev.getName()+ " " + rev.getFullMessage());
		  }
		  git.close();
		}
		}
		catch(Exception e) {
		    e.printStackTrace();
		}
		
}
}
