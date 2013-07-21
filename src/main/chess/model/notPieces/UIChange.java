package main.chess.model.notPieces;

import java.awt.Point;

import main.chess.common.Constants.Tile;
import main.chess.model.pieces.ChessPiece;

public class UIChange {

	private Point source;
	private Point dest;
	
	private Tile sourceTileChange;
	private Tile destTileChange;
	
	/**
	 * Set the points to null if the dest or source doesn't need to change
	 * @param sourceLoc
	 * 					- The 'new' location that this is changing to
	 * @param destLoc
	 * 					- The 'old' location this is changing from
	 * @param sourceTile
	 * 					- The type of tile that should be at the source location
	 * @param destTile
	 * 					- The type of tile that should be at the destination location
	 * @param sourcePiece
	 * 					- The piece that should be at the source location
	 * @param destPiece
	 * 					- The piece that should be at the destination location
	 */
	public UIChange(Point sourceLoc, Point destLoc, Tile sourceTile, Tile destTile) {
		this.source = sourceLoc;
		this.dest = destLoc;
		this.sourceTileChange = sourceTile;
		this.destTileChange = destTile;
	}
	
	public boolean sourceNeedsChange() {
		return source != null;
	}
	
	public boolean destNeedsChange() {
		return dest != null;
	}
	
	@Override
	public int hashCode() {
		final int prime = 23;
		int num = 1;
		num = num * prime + (source != null ? source.hashCode() : 0);
		num = num * prime + (dest != null ? dest.hashCode() : 0);
		num = num * prime + (sourceTileChange != null ? sourceTileChange.hashCode() : 0);
		num = num * prime + (destTileChange != null ? destTileChange.hashCode() : 0);
		return num;
	}
	
	public Point getSource() {
		return source;
	}

	public void setSource(Point source) {
		this.source = source;
	}

	public Point getDest() {
		return dest;
	}

	public void setDest(Point dest) {
		this.dest = dest;
	}

	public Tile getSourceTileChange() {
		return sourceTileChange;
	}

	public void setSourceTileChange(Tile sourceTileChange) {
		this.sourceTileChange = sourceTileChange;
	}

	public Tile getDestTileChange() {
		return destTileChange;
	}

	public void setDestTileChange(Tile destTileChange) {
		this.destTileChange = destTileChange;
	}
}
