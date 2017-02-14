//package cn.maxlu.es;
//
//import org.apache.lucene.document.FieldType;
//
//import javax.persistence.Id;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by max.lu on 2016/2/25.
// */
//@Document(indexName = "talks")
//public class Talk1 {
//    @Id
//    private
//    String path;
//
//    @Field(type = FieldType.String, index = FieldIndex.analyzed, indexAnalyzer = "german", searchAnalyzer = "german")
//    private
//    String title;
//    private List speakers;
//    @Field(type = FieldType.Date)
//    private Date date;
//
//    public String getPath() {
//        return path;
//    }
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public List getSpeakers() {
//        return speakers;
//    }
//
//    public void setSpeakers(List speakers) {
//        this.speakers = speakers;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
