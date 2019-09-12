package model.logic;

public class UBERTrip implements Comparable<UBERTrip>
{
	//Atributos
	
	private int sourceID;
	
	private int dstID;
	
	private int hod;
	
	private double meanTravelTime;
	
	private double standardDeviationTravelTime;
	
	private double geometricMeanTravelTime;
	
	private double geometricStandardDeviationTravelTime;

	public UBERTrip(int sourceID, int dstID, int hod, double meanTravelTime, double standardDeviationTravelTime,
			double geometricMeanTravelTime, double geometricStandardDeviationTravelTime) 
	{
		super();
		this.sourceID = sourceID;
		this.dstID = dstID;
		this.hod = hod;
		this.meanTravelTime = meanTravelTime;
		this.standardDeviationTravelTime = standardDeviationTravelTime;
		this.geometricMeanTravelTime = geometricMeanTravelTime;
		this.geometricStandardDeviationTravelTime = geometricStandardDeviationTravelTime;
	}

	public int getSourceID() {
		return sourceID;
	}

	public int getDstID() {
		return dstID;
	}

	public int getHod() {
		return hod;
	}

	public double getMeanTravelTime() {
		return meanTravelTime;
	}

	public double getStandardDeviationTravelTime() {
		return standardDeviationTravelTime;
	}

	public double getGeometricMeanTravelTime() {
		return geometricMeanTravelTime;
	}

	public double getGeometricStandardDeviationTravelTime() {
		return geometricStandardDeviationTravelTime;
	}
	
		public int compareTo( double pMeanTravelTime) 
	{
		int x = 0; 
		if( meanTravelTime < pMeanTravelTime ) 
		{
			x= -1;
		}
		else if( meanTravelTime > pMeanTravelTime) 
		{
			x=  1;
		}
		
		else 
		{
			if(meanTravelTime == pMeanTravelTime ) 
			{
				if( pMeanTravelTime == standardDeviationTravelTime ) 
				{
					x =0;
				}
				
				else if(pMeanTravelTime > standardDeviationTravelTime ) 
				{
					x= -1;
				}
				
				else 
				{
					if(pMeanTravelTime < standardDeviationTravelTime) 
					{
						x = 1; 
					}
					
					x = 0;	
				}
			}
			
			x = 0;
		}
		
		return x; 
	}
	
	
	
	
	
}	
