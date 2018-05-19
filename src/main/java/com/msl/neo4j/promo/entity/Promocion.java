package com.msl.neo4j.promo.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="promocion")
public class Promocion {

	@Id @GeneratedValue
    public Long id;
	
	@Index
	public String codpromoci;
	
	public String name;
	
	public String canlvnta;
     
    //123 desde 33 a 34
    public String dticprom;
     
    //1 desde 38 a 38
    public String xexcluye;
        
    //123...7 desde 61 a 68
    public String finiefec;
    
    //123...7 desde 69 a 76
    public String ffinefec;
    
    //1234 desde 77 a 80
    public String choraini;
    
    //1234 desde 77 a 80
    public String chorafin;
    
    //12 desde 85 a 87
    public String cemprvnt;
    
    //123 desde 88 a 91
    public String ccentvnt;
    
    //123..29 desde 92 a 111
    public String despromo;
    
    //123..12 desde 112 a 124
    public String ccarpeta;

    //123..49 desde 125 a 174
    public String descarpe;
    
    //123 desde 175 a 177
    public String coorigen;
    
    //123..23 desde 178 a 201
    public String codplaex;
    
    //123 desde 202 a 205
    public String chordiad;
    
    //123 desde 206 a 209
    public String chordiah;
    
    //1 desde 210 a 210
    public String xtipobon;
    
    //1 desde 211 a 211
    public String xusopweb;

    public Promocion() {}
    
    public Promocion(
     	    String codpromoci,
     	    String canlvnta,
     	    String dticprom,
    	    String xexcluye,
     	    String finiefec,
    	    String ffinefec,
    	    String choraini,
    	    String chorafin,
    	    String cemprvnt,
    	    String ccentvnt,
    	    String despromo,
    	    String ccarpeta,
    	    String descarpe,
    	    String coorigen,
    	    String codplaex,
    	    String chordiad,
    	    String chordiah,
    	    String xtipobon,
    	    String xusopweb) {
        super();
        this.name = "promo" + codpromoci;
        this.codpromoci = codpromoci;
        this.canlvnta = canlvnta;
	    this.dticprom = dticprom;
	    this.xexcluye = xexcluye;
	    this.finiefec = finiefec;
	    this.ffinefec = ffinefec;
	    this.choraini = choraini;
	    this.chorafin = chorafin;
	    this.cemprvnt = cemprvnt;
	    this.ccentvnt = ccentvnt;
	    this.despromo = despromo;
	    this.ccarpeta = ccarpeta;
	    this.descarpe = descarpe;
	    this.coorigen = coorigen;
	    this.codplaex = codplaex;
	    this.chordiad = chordiad;
	    this.chordiah = chordiah;
	    this.xtipobon = xtipobon;
	    this.xusopweb = xusopweb;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
        		append("PROMOCION:" + name).
        		append("id", id).
                append("codpromoci", codpromoci).
                append("canlvnta","canlvnta").
          	    append("dticprom", dticprom).
        	    append("xexcluye", xexcluye).
        	    append("finiefec", finiefec).
        	    append("ffinefec", ffinefec).
        	    append("choraini", choraini).
        	    append("chorafin", chorafin).
        	    append("cemprvnt", cemprvnt).
        	    append("ccentvnt", ccentvnt).
        	    append("despromo", despromo).
        	    append("ccarpeta", ccarpeta).
        	    append("descarpe", descarpe).
        	    append("coorigen", coorigen).
        	    append("codplaex", codplaex).
        	    append("chordiad", chordiad).
        	    append("chordiah", chordiah).
        	    append("xtipobon", xtipobon).
        	    append("xusopweb", xusopweb).
        		toString();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpromoci() {
		return codpromoci;
	}

	public void setCpromoci(String codpromoci) {
		this.codpromoci = codpromoci;
	}

	public String getCanlvnta() {
		return canlvnta;
	}

	public void setCanlvnta(String canlvnta) {
		this.canlvnta = canlvnta;
	}

	public String getDticprom() {
		return dticprom;
	}

	public void setDticprom(String dticprom) {
		this.dticprom = dticprom;
	}

	public String getXexcluye() {
		return xexcluye;
	}

	public void setXexcluye(String xexcluye) {
		this.xexcluye = xexcluye;
	}

	public String getFiniefec() {
		return finiefec;
	}

	public void setFiniefec(String finiefec) {
		this.finiefec = finiefec;
	}

	public String getFfinefec() {
		return ffinefec;
	}

	public void setFfinefec(String ffinefec) {
		this.ffinefec = ffinefec;
	}

	public String getChoraini() {
		return choraini;
	}

	public void setChoraini(String choraini) {
		this.choraini = choraini;
	}

	public String getChorafin() {
		return chorafin;
	}

	public void setChorafin(String chorafin) {
		this.chorafin = chorafin;
	}

	public String getCemprvnt() {
		return cemprvnt;
	}

	public void setCemprvnt(String cemprvnt) {
		this.cemprvnt = cemprvnt;
	}

	public String getCcentvnt() {
		return ccentvnt;
	}

	public void setCcentvnt(String ccentvnt) {
		this.ccentvnt = ccentvnt;
	}

	public String getDespromo() {
		return despromo;
	}

	public void setDespromo(String despromo) {
		this.despromo = despromo;
	}

	public String getCcarpeta() {
		return ccarpeta;
	}

	public void setCcarpeta(String ccarpeta) {
		this.ccarpeta = ccarpeta;
	}

	public String getDescarpe() {
		return descarpe;
	}

	public void setDescarpe(String descarpe) {
		this.descarpe = descarpe;
	}

	public String getCoorigen() {
		return coorigen;
	}

	public void setCoorigen(String coorigen) {
		this.coorigen = coorigen;
	}

	public String getCodplaex() {
		return codplaex;
	}

	public void setCodplaex(String codplaex) {
		this.codplaex = codplaex;
	}

	public String getChordiad() {
		return chordiad;
	}

	public void setChordiad(String chordiad) {
		this.chordiad = chordiad;
	}

	public String getChordiah() {
		return chordiah;
	}

	public void setChordiah(String chordiah) {
		this.chordiah = chordiah;
	}

	public String getXtipobon() {
		return xtipobon;
	}

	public void setXtipobon(String xtipobon) {
		this.xtipobon = xtipobon;
	}

	public String getXusopweb() {
		return xusopweb;
	}

	public void setXusopweb(String xusopweb) {
		this.xusopweb = xusopweb;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
