package cynosure.conundrum.polyhedra;

public class SpaceVector {

	private double m_xComponent;
	private double m_yComponent;
	private double m_zComponent;

	// constructors
	SpaceVector() {
	}

	SpaceVector(double _vx, double _vy, double _vz)
	{
		m_xComponent = _vx;
		m_yComponent = _vy;
		m_zComponent = _vz;
	}

	double xComponent(){ return m_xComponent; }
	double yComponent(){ return m_yComponent; }
	double zComponent(){ return m_zComponent; }
	
	public void add(SpaceVector _v)
	{
		m_xComponent += _v.m_xComponent;
		m_yComponent += _v.m_yComponent;
		m_zComponent += _v.m_zComponent;
	}

	// vector addition
	public static SpaceVector add(SpaceVector _v, SpaceVector _w)
	{
		return new SpaceVector(
				_v.m_xComponent + _w.m_xComponent,
				_v.m_yComponent + _w.m_yComponent,
				_v.m_zComponent + _w.m_zComponent);
	}
	
	public void subtract(SpaceVector _v)
	{
		m_xComponent -= _v.m_xComponent;
		m_yComponent -= _v.m_yComponent;
		m_zComponent -= _v.m_zComponent;
	}

	// vector subtraction
	public static SpaceVector subtract(SpaceVector _v, SpaceVector _w)
	{
		return new SpaceVector(
				_v.m_xComponent - _w.m_xComponent,
				_v.m_yComponent - _w.m_yComponent,
				_v.m_zComponent - _w.m_zComponent);
	}

	public void scale(double _a)
	{
		m_xComponent = _a * m_xComponent;
		m_yComponent = _a * m_yComponent;
		m_zComponent = _a * m_zComponent;
	}

	// scalar multiplication
	public static SpaceVector scale(double _a, SpaceVector _v)
	{
		return new SpaceVector(
				_a * _v.m_xComponent,
				_a * _v.m_yComponent,
				_a * _v.m_zComponent);
	}

	// dot product
	public static double dot(SpaceVector _v, SpaceVector _w)
	{
		return _v.m_xComponent * _w.m_xComponent
		+ _v.m_yComponent * _w.m_yComponent
		+ _v.m_zComponent * _w.m_zComponent;
	}

	// cross product
	public static SpaceVector cross(SpaceVector _v, SpaceVector _w)
	{
		return new SpaceVector(
				_v.m_yComponent * _w.m_zComponent - _w.m_yComponent * _v.m_zComponent,
				_v.m_zComponent * _w.m_xComponent - _w.m_zComponent * _v.m_xComponent,
				_v.m_xComponent * _w.m_yComponent - _w.m_xComponent * _v.m_yComponent);
	}

	public double norm()
	{
		return norm(this);
	}

	// vector norm
	public static double norm(SpaceVector _v)
	{
		return Math.sqrt(dot(_v, _v));
	}
}
