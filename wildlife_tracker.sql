--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: age; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE age (
    id integer NOT NULL,
    age character varying
);


ALTER TABLE age OWNER TO "Guest";

--
-- Name: age_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE age_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE age_id_seq OWNER TO "Guest";

--
-- Name: age_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE age_id_seq OWNED BY age.id;


--
-- Name: animals; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE animals (
    id integer NOT NULL,
    species character varying,
    health integer,
    age integer,
    gender integer,
    endangered boolean
);


ALTER TABLE animals OWNER TO "Guest";

--
-- Name: animals_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE animals_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE animals_id_seq OWNER TO "Guest";

--
-- Name: animals_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE animals_id_seq OWNED BY animals.id;


--
-- Name: genders; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE genders (
    id integer NOT NULL,
    gender character varying
);


ALTER TABLE genders OWNER TO "Guest";

--
-- Name: genders_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE genders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE genders_id_seq OWNER TO "Guest";

--
-- Name: genders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE genders_id_seq OWNED BY genders.id;


--
-- Name: health; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE health (
    id integer NOT NULL,
    health character varying
);


ALTER TABLE health OWNER TO "Guest";

--
-- Name: health_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE health_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE health_id_seq OWNER TO "Guest";

--
-- Name: health_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE health_id_seq OWNED BY health.id;


--
-- Name: locations; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE locations (
    id integer NOT NULL,
    name character varying,
    mgrs character varying
);


ALTER TABLE locations OWNER TO "Guest";

--
-- Name: locations_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE locations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE locations_id_seq OWNER TO "Guest";

--
-- Name: locations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE locations_id_seq OWNED BY locations.id;


--
-- Name: rangers; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE rangers (
    id integer NOT NULL,
    name character varying,
    roster_number integer
);


ALTER TABLE rangers OWNER TO "Guest";

--
-- Name: rangers_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE rangers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rangers_id_seq OWNER TO "Guest";

--
-- Name: rangers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE rangers_id_seq OWNED BY rangers.id;


--
-- Name: sightings; Type: TABLE; Schema: public; Owner: Guest
--

CREATE TABLE sightings (
    id integer NOT NULL,
    rangerid integer,
    animalid integer,
    locationid integer,
    sighting_date timestamp without time zone,
    notes character varying
);


ALTER TABLE sightings OWNER TO "Guest";

--
-- Name: sightings_id_seq; Type: SEQUENCE; Schema: public; Owner: Guest
--

CREATE SEQUENCE sightings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sightings_id_seq OWNER TO "Guest";

--
-- Name: sightings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Guest
--

ALTER SEQUENCE sightings_id_seq OWNED BY sightings.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY age ALTER COLUMN id SET DEFAULT nextval('age_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animals ALTER COLUMN id SET DEFAULT nextval('animals_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY genders ALTER COLUMN id SET DEFAULT nextval('genders_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY health ALTER COLUMN id SET DEFAULT nextval('health_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY locations ALTER COLUMN id SET DEFAULT nextval('locations_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY rangers ALTER COLUMN id SET DEFAULT nextval('rangers_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY sightings ALTER COLUMN id SET DEFAULT nextval('sightings_id_seq'::regclass);


--
-- Data for Name: age; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY age (id, age) FROM stdin;
1	recently born
2	youth
3	adolesent
4	adult
5	elderly
\.


--
-- Name: age_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('age_id_seq', 5, true);


--
-- Data for Name: animals; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY animals (id, species, health, age, gender, endangered) FROM stdin;
1	Wolf	1	3	1	t
2	Brown Bear	1	4	2	f
3	Wolf	1	3	1	t
4	Brown Bear	1	4	2	f
5	Wolf	1	3	1	t
6	Brown Bear	1	4	2	f
7	Wolf	1	3	1	t
8	Brown Bear	1	4	2	f
9	Wolf	1	3	1	t
10	Brown Bear	1	4	2	f
11	Wolf	1	3	1	t
12	Brown Bear	1	4	2	f
13	Wolf	1	3	1	t
14	Brown Bear	1	4	2	f
15	Wolf	1	3	1	t
16	Brown Bear	1	4	2	f
17	Wolf	1	3	1	t
18	Brown Bear	1	4	2	f
\.


--
-- Name: animals_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('animals_id_seq', 18, true);


--
-- Data for Name: genders; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY genders (id, gender) FROM stdin;
1	Male
2	Female
3	Unknown
\.


--
-- Name: genders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('genders_id_seq', 3, true);


--
-- Data for Name: health; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY health (id, health) FROM stdin;
1	good
2	fair
3	poor
4	injured/wounded
5	dying
\.


--
-- Name: health_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('health_id_seq', 5, true);


--
-- Data for Name: locations; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY locations (id, name, mgrs) FROM stdin;
\.


--
-- Name: locations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('locations_id_seq', 1, false);


--
-- Data for Name: rangers; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY rangers (id, name, roster_number) FROM stdin;
1	John Clark	5432
2	James Webb	7890
\.


--
-- Name: rangers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('rangers_id_seq', 2, true);


--
-- Data for Name: sightings; Type: TABLE DATA; Schema: public; Owner: Guest
--

COPY sightings (id, rangerid, animalid, locationid, sighting_date, notes) FROM stdin;
\.


--
-- Name: sightings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Guest
--

SELECT pg_catalog.setval('sightings_id_seq', 1, false);


--
-- Name: age_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY age
    ADD CONSTRAINT age_pkey PRIMARY KEY (id);


--
-- Name: animals_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);


--
-- Name: genders_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY genders
    ADD CONSTRAINT genders_pkey PRIMARY KEY (id);


--
-- Name: health_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY health
    ADD CONSTRAINT health_pkey PRIMARY KEY (id);


--
-- Name: locations_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY locations
    ADD CONSTRAINT locations_pkey PRIMARY KEY (id);


--
-- Name: rangers_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY rangers
    ADD CONSTRAINT rangers_pkey PRIMARY KEY (id);


--
-- Name: sightings_pkey; Type: CONSTRAINT; Schema: public; Owner: Guest
--

ALTER TABLE ONLY sightings
    ADD CONSTRAINT sightings_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: epicodus
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM epicodus;
GRANT ALL ON SCHEMA public TO epicodus;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

