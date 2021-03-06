package lee;

import org.crazyit.app.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Test {
	public static void main(String[] args)
			throws Exception
		{
			//实例化Configuration，
			Configuration conf = new Configuration()
			//下面方法默认加载hibernate.cfg.xml文件
				.configure();
			//以Configuration创建SessionFactory
			SessionFactory sf = conf.buildSessionFactory();
			//创建Session
			Session sess = sf.openSession();
			//开始事务
			Transaction tx = sess.beginTransaction();
			//创建消息实例
			SchemaExport SchemaExportschemaExport = new SchemaExport(conf);
			SchemaExportschemaExport.create(true,true);
			   System.out.println("Tablecreated.");
			//提交事务
			tx.commit();
			//关闭Session
			sess.close();
			sf.close();
		}
}
