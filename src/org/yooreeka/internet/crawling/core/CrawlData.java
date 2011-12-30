package org.yooreeka.internet.crawling.core;


import java.io.File;

import org.yooreeka.internet.crawling.db.FetchedDocsDB;
import org.yooreeka.internet.crawling.db.KnownUrlDB;
import org.yooreeka.internet.crawling.db.PageLinkDB;
import org.yooreeka.internet.crawling.db.ProcessedDocsDB;

public class CrawlData {
    
    private File crawlRootDir;
    
    private FetchedDocsDB fetchedDocsDB;
    private ProcessedDocsDB processedDocsDB;
    private KnownUrlDB knownUrlsDB;
    private PageLinkDB pageLinkDB;
    
    public File getCrawlRootDir() {
        return crawlRootDir;
    }

    public KnownUrlDB getKnownUrlsDB() {
        return knownUrlsDB;
    }

    public PageLinkDB getPageLinkDB() {
        return pageLinkDB;
    }

    public FetchedDocsDB getFetchedDocsDB() {
        return fetchedDocsDB;
    }

    public ProcessedDocsDB getProcessedDocsDB() {
        return processedDocsDB;
    }

    public CrawlData(String rootDir) {
        this.crawlRootDir = new File(rootDir);
        crawlRootDir.mkdirs();
        
        File fetchedDocsDBRoot = new File(crawlRootDir, "fetched");
        this.fetchedDocsDB = new FetchedDocsDB(fetchedDocsDBRoot);
        
        File processedDocsDBRoot = new File(crawlRootDir, "processed");
        this.processedDocsDB = new ProcessedDocsDB(processedDocsDBRoot);
        
        File knownUrlsDBRoot = new File(crawlRootDir, "knownurls");
        this.knownUrlsDB = new KnownUrlDB(knownUrlsDBRoot);

        File pageLinkDBRoot = new File(crawlRootDir, "pagelinks");
        this.pageLinkDB = new PageLinkDB(pageLinkDBRoot);
    }
    
    public void init() {
        this.fetchedDocsDB.init();
        this.processedDocsDB.init();
        this.knownUrlsDB.init();
        this.pageLinkDB.init();
    }
    
    public void delete() {
        this.fetchedDocsDB.delete();
        this.processedDocsDB.delete();
        this.knownUrlsDB.delete();
        this.pageLinkDB.delete();
    }
}