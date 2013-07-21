package main.chess.model.notPieces;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UIChangeList implements Iterable<UIChange> {
	private Set<UIChange> changes;
	
	public UIChangeList() {
		changes = new HashSet<UIChange>();
	}
	
	public boolean isEmpty() {
		return changes.isEmpty();
	}
	
	public void addChange(UIChange change) {
		changes.add(change);
	}

	//Lol now i can use for-each loops
	@Override
	public Iterator<UIChange> iterator() {
		return changes.iterator();
	}
}
