package fr.ft.aviscogl.norm;

public enum NormType
{
    WARNING, ERROR;

    @Override
    public String toString()
    {
       switch (this) {
           case ERROR: return "Error";
           case WARNING: return "Warning";
       }
       return "None";
    }
}
