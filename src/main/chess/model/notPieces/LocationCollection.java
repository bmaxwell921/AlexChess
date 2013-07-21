package main.chess.model.notPieces;

import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class LocationCollection {
	private Set<Point> locs;
	
	public LocationCollection() {
		locs = new HashSet<Point>();
	}
	
	public void add(Point loc) {
		locs.add(loc);
	}
	
	public Collection<Point> getLocations() {
		return locs;
	}

	public boolean contains(Point location) {
		return locs.contains(location);
	}
}
