package joeschweitzer

/**
 * Domain class representing a class mapped to a really big table or view
 * which does not return a total count quickly.
 * 
 * When this class is modified, HibernatePluginSupport will call count() which 
 * could potentially hang our auto reload and also make our DBAs unhappy.  
 * 
 * We can potentially just override count() in classes like these to return 
 * something like 0 or -1 and assume that developers know they should not be 
 * calling count() on a domain class like this.
 */
class SlowCount {
	
	static mapping = {
		table 'really_big_table_or_view'
	}
	
	static int count() {
		println 'Slow count called'
		return 0
	}
}
