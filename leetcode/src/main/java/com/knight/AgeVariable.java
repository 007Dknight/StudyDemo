package com.knight;


public class AgeVariable extends VariableEntity {
    private static final long serialVersionUID = 1L;

    private AgeContent content;

    public class AgeContent{
        //系统变量名称
        private String variableId;

        public String getVariableId() {
            return variableId;
        }

        public void setVariableId(String variableId) {
            this.variableId = variableId;
        }

        @Override
        public String toString() {
            return "AgeContent{" +
                    "variableId='" + variableId + '\'' +
                    '}';
        }
    }

    public AgeContent getContent() {
        return content;
    }

    public void setContent(AgeContent content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AgeVariable{" +
                "content=" + content +
                '}';
    }
}
