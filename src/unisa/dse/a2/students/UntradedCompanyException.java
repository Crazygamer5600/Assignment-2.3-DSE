package unisa.dse.a2.students;

public class UntradedCompanyException
{
	public UntradedCompanyException(String companyCode) throws Exception{
		throw new Exception('"' + companyCode + "is not a listed company on this exchange" + '"');
	}
}
